package ar.com.heroes.controllers;

import ar.com.heroes.model.domain.role.RoleEntity;
import ar.com.heroes.services.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/roles")
public class RoleRestController {

    @Autowired
    private IRoleService roleService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getRoles(){
        List<RoleEntity> roles = roleService.getAll();
        if(roles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRoleEntity(@PathVariable("id") int id) {
        /*return this.roles.stream().filter(role -> role.getRoleId() == id).findFirst().orElse(null);*/
        RoleEntity role = roleService.getById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST , consumes = "application/json")
    public ResponseEntity<?> saveRoleEntity(@RequestBody RoleEntity role) {
        long id = roleService.insert(role).getId();
        return ResponseEntity.ok().body(id);
    }



    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateRoleEntity(@RequestBody RoleEntity role) {
        RoleEntity currentRole = roleService.update(role);
        return ResponseEntity.ok().body(currentRole);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRoleEntity(@PathVariable int id) {
        RoleEntity deletedRole = roleService.getById(id);
        return deletedRole != null ? ResponseEntity.ok().body(roleService.delete(deletedRole)) : ResponseEntity.status(500).body(null);
    }
    
}
