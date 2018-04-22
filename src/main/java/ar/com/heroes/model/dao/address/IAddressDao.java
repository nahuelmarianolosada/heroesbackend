package ar.com.heroes.model.dao.address;

import ar.com.heroes.model.domain.address.AddressEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface IAddressDao {
    int insert(AddressEntity newAddress);

    AddressEntity getAddressById(int addressId);

    AddressEntity getAddressByPhone(String phone);

    List<AddressEntity> getAddresses();
}
