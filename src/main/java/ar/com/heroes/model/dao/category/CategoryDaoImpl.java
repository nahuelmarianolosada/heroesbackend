package ar.com.heroes.model.dao.category;

import ar.com.heroes.model.domain.category.CategoryEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 18/04/18.
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements ICategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertCategory(CategoryEntity category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Override
    public CategoryEntity getCategoryById(int categoryId) {
        return (CategoryEntity) sessionFactory.
                getCurrentSession().
                get(CategoryEntity.class, categoryId);
    }

    @Override
    public CategoryEntity getCategoryByName(String name) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from CategoryEntity where name = :name");
        query.setParameter("name", name);
        return (CategoryEntity) query.list().get(0);
    }

    @Override
    public List<CategoryEntity> getCategories() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(CategoryEntity.class);
        return criteria.list();
    }
}
