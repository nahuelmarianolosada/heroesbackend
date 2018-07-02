package ar.com.heroes.model.dao.user;

import ar.com.heroes.model.domain.user.UserEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public UserEntity save(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }


}
