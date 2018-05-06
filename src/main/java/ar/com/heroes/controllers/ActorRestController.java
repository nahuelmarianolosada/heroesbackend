package ar.com.heroes.controllers;

import ar.com.heroes.services.actor.IActorService;
import ar.com.heroes.model.domain.actor.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by root on 03/02/18.
 */


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/actors")
public class ActorRestController {


    @Autowired
    private IActorService actorService;


    ActorRestController() {
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public List<ActorEntity> getActorEntitys() {
        return actorService.getAll();
    }*/


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getActors(){
        List<ActorEntity> actors = actorService.getAll();
        if(actors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getActorEntity(@PathVariable("id") int id) {
        /*return this.actors.stream().filter(actor -> actor.getActorId() == id).findFirst().orElse(null);*/
        ActorEntity actor = actorService.getById(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST , consumes = "application/json")
    public ResponseEntity<?> saveActorEntity(@RequestBody ActorEntity actor) {
        /*int nextId = 0;
        if (this.actors.size() != 0) {
            ActorEntity lastActorEntity = this.actors.stream().skip(this.actors.size() - 1).findFirst().orElse(null);
            nextId = lastActorEntity.getActorId() + 1;
        }

        actor.setActorId(nextId);
        this.actors.add(actor);
        return actor;*/
        long id = actorService.insert(actor).getActorId();
        return ResponseEntity.ok().body(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateActorEntity(@RequestBody ActorEntity actor) {
       /* ActorEntity modifiedActorEntity = this.actors.stream().filter(u -> u.getActorId() == actor.getActorId()).findFirst().orElse(null);
        modifiedActorEntity.setFirstName(actor.getFirstName());
        modifiedActorEntity.setLastName(actor.getLastName());
        return modifiedActorEntity;*/
        ActorEntity currentActor = actorService.update(actor);
        return ResponseEntity.ok().body(currentActor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteActorEntity(@PathVariable int id) {
       /* ActorEntity deleteActorEntity = this.actors.stream().filter(actor -> actor.getActorId() == id).findFirst().orElse(null);
        if (deleteActorEntity != null) {
            this.actors.remove(deleteActorEntity);
            return true;
        } else  {
            return false;
        }*/
        ActorEntity deletedActor = actorService.getById(id);
        deletedActor = actorService.delete(deletedActor);
        return deletedActor != null ? ResponseEntity.ok().body(deletedActor) : ResponseEntity.status(500).body(null);
    }


}