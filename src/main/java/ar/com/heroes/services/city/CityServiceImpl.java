package ar.com.heroes.services.city;

import ar.com.heroes.model.dao.city.ICityDao;
import ar.com.heroes.model.domain.city.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    ICityDao dao;

    @Override
    public List<CityEntity> getAll() {
        return dao.getCitys();
    }

    @Override
    public CityEntity getCityById(int cityId) {
        return dao.getCityById(cityId);
    }

    @Override
    public CityEntity getCityByName(String name) {
        return dao.getCity(name);
    }
}
