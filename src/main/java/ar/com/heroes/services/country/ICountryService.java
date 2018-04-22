package ar.com.heroes.services.country;

import ar.com.heroes.model.domain.country.CountryEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface ICountryService {

    List<CountryEntity> getAll();
    CountryEntity getCountryById(int countryId);
    CountryEntity getCountryByName(String name);
    
}
