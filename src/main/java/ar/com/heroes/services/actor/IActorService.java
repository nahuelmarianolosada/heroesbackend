package ar.com.heroes.services.actor;

import ar.com.heroes.model.domain.actor.ActorEntity;

import java.util.List;

/**
 * Created by nlosada on 16/04/18.
 */

public interface IActorService {
    List<ActorEntity> getAll();
    ActorEntity getById(int idActor);
    ActorEntity insert(ActorEntity newActor);
    ActorEntity update(ActorEntity updateActor);
    ActorEntity delete(ActorEntity actor);
}
