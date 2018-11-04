package ar.com.heroes.model.dao.store;

import ar.com.heroes.model.domain.store.StoreEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 30/10/18.
 */
@Repository("storeDao")
public class StoreDaoImpl implements IStoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public StoreEntity insertStore(StoreEntity store) {
        sessionFactory.getCurrentSession().save(store);
        return store;
    }


    @Override
    public StoreEntity updateStore(StoreEntity store) {
        try {
            sessionFactory.getCurrentSession().update(store);
            return store;
        }catch (Exception ex){
            return null;
        }
    }


    @Override
    public StoreEntity deleteStore(StoreEntity store) {
        try {
            sessionFactory.getCurrentSession().delete(store);
            return store;
        }catch(Exception ex){return null;}
    }
    
    
    @Override
    public StoreEntity getStoreById(int storeId) {
        return (StoreEntity) sessionFactory.
                getCurrentSession().
                get(StoreEntity.class, storeId);
    }

    @Override
    public List<StoreEntity> getStores() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(StoreEntity.class)
                .addOrder(Order.asc("storeId"));
        return criteria.list();
    }
}
