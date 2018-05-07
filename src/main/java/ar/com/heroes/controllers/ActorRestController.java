package ar.com.heroes.controllers;

import ar.com.heroes.model.domain.actor.ActorInfoEntity;
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


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> getActors(){
        List<ActorEntity> actors = actorService.getAll();
        if(actors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }



    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<?> getActorsInfoEntity() {
        List<?> actorsInfo = actorService.getAllWithInfo();
        if (actorsInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actorsInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getActorInfoEntity(@PathVariable("id") int id) {
        ActorInfoEntity actorsInfo = actorService.getWithInfo(id);
        if (actorsInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actorsInfo, HttpStatus.OK);
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
        long id = actorService.insert(actor).getActorId();
        return ResponseEntity.ok().body(id);
    }



    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateActorEntity(@RequestBody ActorEntity actor) {
        ActorEntity currentActor = actorService.update(actor);
        return ResponseEntity.ok().body(currentActor);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteActorEntity(@PathVariable int id) {
        ActorEntity deletedActor = actorService.getById(id);
        return deletedActor != null ? ResponseEntity.ok().body(actorService.delete(deletedActor)) : ResponseEntity.status(500).body(null);
    }


}