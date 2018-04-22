package ar.com.heroes.services.city;

import ar.com.heroes.model.domain.city.CityEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface ICityService {

    List<CityEntity> getAll();
    CityEntity getCityById(int cityId);
    CityEntity getCityByName(String name);

}
