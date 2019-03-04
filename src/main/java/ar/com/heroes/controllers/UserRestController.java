package ar.com.heroes.controllers;

import ar.com.heroes.model.domain.user.UserEntity;
import ar.com.heroes.services.user.IUserService;
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
@RequestMapping(value = "/users")
public class UserRestController {


    @Autowired
    private IUserService userService;


    UserRestController() {
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getUsers(){
        List<UserEntity> users = userService.getAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }







    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserEntity(@PathVariable("id") int id) {
        /*return this.users.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);*/
        UserEntity user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/findByEmail/{email:.+}",
            method = RequestMethod.GET)
    public ResponseEntity<?> getUserEntity(@PathVariable("email") String email) {
        UserEntity staff = userService.findByEmail(email);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        staff.setPass(null);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST , consumes = "application/json")
    public ResponseEntity<?> saveUserEntity(@RequestBody UserEntity user) {
        long id = userService.insert(user).getId();
        return ResponseEntity.ok().body(id);
    }



    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserEntity(@RequestBody UserEntity user) {
        UserEntity currentUser = userService.update(user);
        return ResponseEntity.ok().body(currentUser);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserEntity(@PathVariable int id) {
        UserEntity deletedUser = userService.getById(id);
        return deletedUser != null ? ResponseEntity.ok().body(userService.delete(deletedUser)) : ResponseEntity.status(500).body(null);
    }


}