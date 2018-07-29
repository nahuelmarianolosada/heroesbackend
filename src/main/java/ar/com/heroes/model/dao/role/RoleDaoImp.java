package ar.com.heroes.model.dao.role;

import ar.com.heroes.model.domain.role.RoleEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */
@Repository("roleDao")
public class RoleDaoImp implements IRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public RoleEntity insertRole(RoleEntity role) {
        sessionFactory.getCurrentSession().save(role);
        return role;
    }

    @Override
    public RoleEntity updateRole(RoleEntity role) {
        sessionFactory.getCurrentSession().update(role);
        return role;
    }

    @Override
    public RoleEntity delete(RoleEntity role) {
        sessionFactory.getCurrentSession().delete(role);
        return role;
    }

    @Override
    public RoleEntity getRoleById(int roleId) {
        return (RoleEntity) sessionFactory.
                getCurrentSession().
                get(RoleEntity.class, roleId);
    }

    @Override
    public List<RoleEntity> getRoles() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(RoleEntity.class)
                .addOrder(Order.asc("id"));
        return criteria.list();
    }
}
