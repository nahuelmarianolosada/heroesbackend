package ar.com.heroes.services.store;

import ar.com.heroes.model.dao.role.IRoleDao;
import ar.com.heroes.model.dao.store.IStoreDao;
import ar.com.heroes.model.domain.role.RoleEntity;
import ar.com.heroes.model.domain.store.StoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */

@Service("storeServiceImpl")
@Transactional
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private IStoreDao storeDao;

    @Override
    public List<StoreEntity> getAll() {
        return storeDao.getStores();
    }

    @Override
    public StoreEntity getById(int idStore) {
        return storeDao.getStoreById(idStore);
    }

    @Override
    public StoreEntity insert(StoreEntity newStore) {
        return null;
    }

    @Override
    public StoreEntity update(StoreEntity updateStore) {
        return null;
    }

    @Override
    public StoreEntity delete(StoreEntity store) {
        return null;
    }

    /*@Override
    public StoreEntity insert(StoreEntity newStore) {
        return storeDao.insertStore(newStore);
    }*/

    /*
    @Override
    public StoreEntity update(StoreEntity updateStore) {
        return storeDao.updateStore(updateStore);
    }

    @Override
    public StoreEntity delete(StoreEntity store) {
        return storeDao.delete(store);
    }*/
}
