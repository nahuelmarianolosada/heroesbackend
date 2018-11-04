package ar.com.heroes.model.dao.store;

import ar.com.heroes.model.domain.store.StoreEntity;

import java.util.List;

/**
 * Created by nlosada on 30/10/18.
 */
public interface IStoreDao {
    StoreEntity getStoreById(int storeId);

    List<StoreEntity> getStores();

    public StoreEntity insertStore(StoreEntity store);
    public StoreEntity updateStore(StoreEntity store);
    public StoreEntity deleteStore(StoreEntity store);
}
