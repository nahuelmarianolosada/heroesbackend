package ar.com.heroes.model.dao.city;

import ar.com.heroes.model.domain.city.CityEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface ICityDao {
    void insertCity(CityEntity user);

    CityEntity getCityById(int cityId);

    CityEntity getCity(String name);

    List<CityEntity> getCitys();
}
