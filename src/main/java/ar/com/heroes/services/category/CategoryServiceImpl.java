package ar.com.heroes.services.category;

import ar.com.heroes.model.dao.category.ICategoryDao;
import ar.com.heroes.model.domain.category.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryDao dao;

    @Override
    public List<CategoryEntity> getAll() {
        return dao.getCategories();
    }

    @Override
    public CategoryEntity getCategoryById(int addressId) {
        return dao.getCategoryById(addressId);
    }

    @Override
    public CategoryEntity getCategoryByName(String name) {
        return dao.getCategoryByName(name);
    }
}
