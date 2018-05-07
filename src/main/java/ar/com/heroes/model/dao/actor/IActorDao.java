package ar.com.heroes.model.dao.actor;

import ar.com.heroes.model.domain.actor.ActorEntity;
import ar.com.heroes.model.domain.actor.ActorInfoEntity;

import java.util.List;

/**
 * Created by nlosada on 16/04/18.
 */
public interface IActorDao {
    ActorEntity insertActor(ActorEntity actor);

    ActorEntity updateActor(ActorEntity actor);

    ActorEntity delete(ActorEntity actor);

    ActorEntity getActorById(int actorId);

    ActorEntity getActor(String username);

    List<ActorEntity> getActors();

    List<ActorInfoEntity> getActorsInfo();

    ActorInfoEntity getActorInfo(int id);
}
