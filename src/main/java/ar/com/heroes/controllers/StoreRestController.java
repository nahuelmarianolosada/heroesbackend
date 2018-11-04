package ar.com.heroes.controllers;

import ar.com.heroes.model.domain.store.StoreEntity;
import ar.com.heroes.services.store.IStoreService;
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
@RequestMapping(value = "/store")
public class StoreRestController {

    @Autowired
    private IStoreService storeService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getStores(){
        List<StoreEntity> stores = storeService.getAll();
        if(stores.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStoreEntity(@PathVariable("id") int id) {
        /*return this.stores.stream().filter(store -> store.getStoreId() == id).findFirst().orElse(null);*/
        StoreEntity store = storeService.getById(id);
        if (store == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(store, HttpStatus.OK);
    }



   @RequestMapping(method = RequestMethod.POST , consumes = "application/json")
    public ResponseEntity<?> saveStoreEntity(@RequestBody StoreEntity store) {
        long id = storeService.insert(store).getStoreId();
        return ResponseEntity.ok().body(id);
    }





    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateStoreEntity(@RequestBody StoreEntity store) {
        StoreEntity currentStore = storeService.update(store);
        return ResponseEntity.ok().body(currentStore);
    }

/*
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRoleEntity(@PathVariable int id) {
        RoleEntity deletedRole = roleService.getById(id);
        return deletedRole != null ? ResponseEntity.ok().body(roleService.delete(deletedRole)) : ResponseEntity.status(500).body(null);
    }*/
    
}
