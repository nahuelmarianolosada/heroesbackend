package ar.com.heroes.services.store;

import ar.com.heroes.model.domain.store.StoreEntity;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */
public interface IStoreService {
    List<StoreEntity> getAll();
    StoreEntity getById(int storeId);
    StoreEntity insert(StoreEntity newStore);
    StoreEntity update(StoreEntity updateStore);
    StoreEntity delete(StoreEntity store);
}
