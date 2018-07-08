package ar.com.heroes.model.dao.user;

import ar.com.heroes.model.domain.user.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 15/05/18.
 */

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public UserEntity findByEmail(String email) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from UserEntity where email = :email");
        query.setParameter("email", email);
        return (UserEntity) query.uniqueResult();
    }

   /* @Override
    public UserEntity save(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }*/

    @Override
    public UserEntity insertUser(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return user;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public UserEntity delete(UserEntity user) {
        try {
            sessionFactory.getCurrentSession().delete(user);
            return user;
        }catch(Exception ex){return null;}
    }

    @Override
    public UserEntity getUserById(int id) {
        return (UserEntity) sessionFactory.
                getCurrentSession().
                get(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> getUsers() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(UserEntity.class)
                .addOrder(Order.asc("id"));
        return criteria.list();
    }


}
