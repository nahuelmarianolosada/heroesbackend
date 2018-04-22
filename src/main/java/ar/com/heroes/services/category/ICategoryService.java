package ar.com.heroes.services.category;

import ar.com.heroes.model.domain.category.CategoryEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface ICategoryService {

    List<CategoryEntity> getAll();
    CategoryEntity getCategoryById(int addressId);
    CategoryEntity getCategoryByName(String name);

}
