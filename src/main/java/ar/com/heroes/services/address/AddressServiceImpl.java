package ar.com.heroes.services.address;

import ar.com.heroes.model.dao.address.IAddressDao;
import ar.com.heroes.model.domain.address.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

    @Autowired
    IAddressDao dao;

    @Override
    public List<AddressEntity> getAll() {
        return dao.getAddresses();
    }

    @Override
    public AddressEntity getById(int addressId) {
        return dao.getAddressById(addressId);
    }

    @Override
    public AddressEntity getByPhone(String phone) {
        return dao.getAddressByPhone(phone);
    }

    @Override
    public int insert(AddressEntity newAddress) {
        return dao.insert(newAddress);
    }
}
