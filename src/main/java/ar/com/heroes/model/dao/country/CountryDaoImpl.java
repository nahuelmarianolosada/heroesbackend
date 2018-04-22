package ar.com.heroes.model.dao.country;

import ar.com.heroes.model.domain.country.CountryEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Repository("countryDao")
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertCountry(CountryEntity country) {
        sessionFactory.getCurrentSession().save(country);
    }

    @Override
    public CountryEntity getCountryById(int countryId) {
        return (CountryEntity) sessionFactory.
                getCurrentSession().
                get(CountryEntity.class, countryId);
    }

    @Override
    public CountryEntity getCountry(String name) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from CountryEntity where country = :name");
        query.setParameter("name", name);
        return (CountryEntity) query.list().get(0);
    }

    @Override
    public List<CountryEntity> getCountries() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(CountryEntity.class);
        return criteria.list();
    }
}
