package ar.com.heroes.services.country;

import ar.com.heroes.model.dao.country.ICountryDao;
import ar.com.heroes.model.domain.country.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

    @Autowired
    ICountryDao dao;

    @Override
    public List<CountryEntity> getAll() {
        return dao.getCountries();
    }

    @Override
    public CountryEntity getCountryById(int countryId) {
        return dao.getCountryById(countryId);
    }

    @Override
    public CountryEntity getCountryByName(String name) {
        return dao.getCountry(name);
    }
}
