package ar.com.heroes.model.dao.category;

import ar.com.heroes.model.domain.category.CategoryEntity;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
public interface ICategoryDao {
    void insertCategory(CategoryEntity category);

    CategoryEntity getCategoryById(int categoryId);

    CategoryEntity getCategoryByName(String name);

    List<CategoryEntity> getCategories();
}
