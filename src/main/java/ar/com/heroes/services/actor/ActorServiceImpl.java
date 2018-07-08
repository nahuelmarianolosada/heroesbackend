package ar.com.heroes.services.actor;

import ar.com.heroes.model.dao.actor.IActorDao;
import ar.com.heroes.model.domain.actor.ActorEntity;
import ar.com.heroes.model.domain.actor.ActorInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 16/04/18.
 */
@Transactional
@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    IActorDao dao;

    @Override
    public List<ActorEntity> getAll() {
        return dao.getActors();
    }

    @Override
    public List<ActorInfoEntity> getAllWithInfo() {
        return dao.getActorsInfo();
    }


    @Override
    public ActorInfoEntity getWithInfo(int id) {
        return dao.getActorInfo(id);
    }

    @Override
    public ActorEntity getById(int idActor) {
        return dao.getActorById(idActor);
    }


    @Override
    @Transactional
    public ActorEntity insert(ActorEntity newActor) {
        return dao.insertActor(newActor);
    }

    @Override
    @Transactional
    public ActorEntity update(ActorEntity updateActor) {
        return dao.updateActor(updateActor);
    }

    @Override
    @Transactional
    public ActorEntity delete(ActorEntity actor) {
        return dao.delete(actor);
    }


}
