package ar.com.heroes.model.dao.city;

import ar.com.heroes.model.domain.city.CityEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Repository("cityDao")
public class CityDaoImpl implements ICityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertCity(CityEntity city) {
        sessionFactory.getCurrentSession().save(city);
    }

    @Override
    public CityEntity getCityById(int cityId) {
        return (CityEntity) sessionFactory.
                getCurrentSession().
                get(CityEntity.class, cityId);
    }

    @Override
    public CityEntity getCity(String name) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from CityEntity where city = :name");
        query.setParameter("name", name);
        return (CityEntity) query.list().get(0);
    }

    @Override
    public List<CityEntity> getCitys() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(CityEntity.class);
        return criteria.list();
    }
}
