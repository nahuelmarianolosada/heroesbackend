package ar.com.heroes.services.address;

import ar.com.heroes.model.domain.address.AddressEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface IAddressService {
    List<AddressEntity> getAll();
    AddressEntity getById(int addressId);
    AddressEntity getByPhone(String phone);
    int insert(AddressEntity newAddress);

}
