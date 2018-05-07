package ar.com.heroes.services.actor;

import ar.com.heroes.model.domain.actor.ActorEntity;
import ar.com.heroes.model.domain.actor.ActorInfoEntity;

import java.util.List;

/**
 * Created by nlosada on 16/04/18.
 */

public interface IActorService {
    List<ActorEntity> getAll();
    List<ActorInfoEntity> getAllWithInfo();
    ActorInfoEntity getWithInfo(int id);
    ActorEntity getById(int idActor);
    ActorEntity insert(ActorEntity newActor);
    ActorEntity update(ActorEntity updateActor);
    ActorEntity delete(ActorEntity actor);
}
