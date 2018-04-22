package ar.com.heroes.model.dao.country;

import ar.com.heroes.model.domain.country.CountryEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface ICountryDao {
    void insertCountry(CountryEntity country);

    CountryEntity getCountryById(int countryId);

    CountryEntity getCountry(String name);

    List<CountryEntity> getCountries();
}
