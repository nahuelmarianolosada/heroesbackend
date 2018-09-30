package ar.com.heroes.controllers;

import ar.com.heroes.model.domain.staff.StaffEntity;
import ar.com.heroes.services.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 03/02/18.
 */


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/staff")
public class StaffRestController {


    @Autowired
    private IStaffService staffService;


    StaffRestController() {
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getStaff(){
        List<StaffEntity> staffs = staffService.getAll();
        if(staffs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }







    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStaffEntity(@PathVariable("id") int id) {
        /*return this.staffs.stream().filter(staff -> staff.getStaffId() == id).findFirst().orElse(null);*/
        StaffEntity staff = staffService.getById(id);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }



    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getStaffEntity(@PathVariable("email") String email) {
            StaffEntity staff = staffService.findByEmail(email);
            if (staff == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(staff, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST , consumes = "application/json")
    public ResponseEntity<?> saveStaffEntity(@RequestBody StaffEntity staff) {
        long id = staffService.insert(staff).getStaffId();
        return ResponseEntity.ok().body(id);
    }



    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateStaffEntity(@RequestBody StaffEntity staff) {
        StaffEntity currentStaff = staffService.update(staff);
        return ResponseEntity.ok().body(currentStaff);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStaffEntity(@PathVariable int id) {
        StaffEntity deletedStaff = staffService.getById(id);
        return deletedStaff != null ? ResponseEntity.ok().body(staffService.delete(deletedStaff)) : ResponseEntity.status(500).body(null);
    }


}