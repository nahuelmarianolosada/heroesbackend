package ar.com.heroes.model.dao.staff;

import ar.com.heroes.model.domain.staff.StaffEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 15/05/18.
 */

@Repository("staffDao")
public class StaffDaoImpl implements IStaffDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    /***
     * private int staffId;
     private String firstName;
     private String lastName;
     private String email;
     private short storeId;
     private boolean active;
     private String username;
     private String password;
     private Timestamp lastUpdate;
     private byte[] picture;
     */
    public StaffEntity findByEmail(String email) {
        Query query = sessionFactory.
                getCurrentSession().
                createQuery("from StaffEntity where email = :email");
        query.setParameter("email", email);
        return (StaffEntity) query.uniqueResult();
    }

    @Override
    public StaffEntity get(String email) {
        return (StaffEntity) sessionFactory.getCurrentSession()
                .createCriteria(StaffEntity.class)
                .add( Restrictions.eq("email", email))
                /*.setProjection(Projections.projectionList()
                        .add(Projections.property("staffId"))
                        .add(Projections.property("firstName"))
                        .add(Projections.property("lastName"))
                        .add(Projections.property("email"))
                        .add(Projections.property("active"))
                        .add(Projections.property("username"))
                        .add(Projections.property("lastUpdate"))
                        .add(Projections.property("picture")))
                .setResultTransformer(Transformers.aliasToBean(StaffEntity.class))*/
                .uniqueResult();
    }


    @Override
    public StaffEntity insertStaff(StaffEntity staff) {
        sessionFactory.getCurrentSession().save(staff);
        return staff;
    }

    @Override
    public StaffEntity updateStaff(StaffEntity staff) {
        try {
            sessionFactory.getCurrentSession().update(staff);
            return staff;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public StaffEntity delete(StaffEntity staff) {
        try {
            sessionFactory.getCurrentSession().delete(staff);
            return staff;
        }catch(Exception ex){return null;}
    }

    @Override
    public StaffEntity getStaffById(int id) {
        return (StaffEntity) sessionFactory.
                getCurrentSession().
                get(StaffEntity.class, id);
    }

    @Override
    public List<StaffEntity> getStaff() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(StaffEntity.class)
                .addOrder(Order.asc("firstName"));
        return criteria.list();
    }


}
