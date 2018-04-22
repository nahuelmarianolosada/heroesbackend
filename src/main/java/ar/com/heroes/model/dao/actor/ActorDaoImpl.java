package ar.com.heroes.model.dao.actor;

import ar.com.heroes.model.domain.actor.ActorEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 16/04/18.
 */

@Repository("actorDao")
public class ActorDaoImpl implements IActorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ActorEntity insertActor(ActorEntity actor) {
        sessionFactory.getCurrentSession().save(actor);
        return actor;
    }


    @Override
    public ActorEntity updateActor(ActorEntity actor) {
        sessionFactory.getCurrentSession().update(actor);
        return actor;
    }


    @Override
    public ActorEntity delete(ActorEntity actor) {
        sessionFactory.getCurrentSession().delete(actor);
        return actor;
    }



    @Override
    public ActorEntity getActorById(int actorId) {
        return (ActorEntity) sessionFactory.
                getCurrentSession().
                get(ActorEntity.class, actorId);
    }

    @Override
    public ActorEntity getActor(String firstname) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from ActorEntity where firstName = :firstname");
        query.setParameter("firstname", firstname);
        return (ActorEntity) query.list().get(0);
    }

    @Override
    public List<ActorEntity> getActors() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(ActorEntity.class)
                .addOrder(Order.desc("lastUpdate"));
        return criteria.list();
    }
}
