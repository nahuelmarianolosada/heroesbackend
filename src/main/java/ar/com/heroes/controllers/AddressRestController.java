package ar.com.heroes.controllers;

import ar.com.heroes.model.domain.address.AddressEntity;
import ar.com.heroes.services.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@RestController
@RequestMapping(value = "/address")
public class AddressRestController {

    @Autowired
    private IAddressService addressService;


    AddressRestController() {}

    @RequestMapping(method = RequestMethod.GET)
    public List<AddressEntity> getAddressEntitys() {
        return addressService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AddressEntity getAddressEntity(@PathVariable("id") int id) {
        /*return this.actors.stream().filter(actor -> actor.getAddressId() == id).findFirst().orElse(null);*/
        return addressService.getById(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveAddressEntity(@RequestBody AddressEntity newAddress) {
        int id = addressService.insert(newAddress);
        return ResponseEntity.ok().body("New Address has been saved with ID:" + id);
    }
    
}
