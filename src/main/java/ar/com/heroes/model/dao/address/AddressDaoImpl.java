package ar.com.heroes.model.dao.address;

import ar.com.heroes.model.domain.address.AddressEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */

@Repository("addressDao")
public class AddressDaoImpl implements IAddressDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public int insert(AddressEntity newAddress) {
        sessionFactory.getCurrentSession().save(newAddress);
        return newAddress.getAddressId();
    }

    @Override
    public AddressEntity getAddressById(int addressId) {
        return (AddressEntity) sessionFactory.
                getCurrentSession().
                get(AddressEntity.class, addressId);
    }

    @Override
    public AddressEntity getAddressByPhone(String phone) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from AddressEntity where phone = :phone");
        query.setParameter("phone", phone);
        return (AddressEntity) query.list().get(0);
    }

    @Override
    public List<AddressEntity> getAddresses() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(AddressEntity.class);
        return criteria.list();
    }
}
