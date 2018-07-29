package ar.com.heroes.services.role;

import ar.com.heroes.model.dao.role.IRoleDao;
import ar.com.heroes.model.domain.role.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */

@Service("roleServiceImpl")
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<RoleEntity> getAll() {
        return roleDao.getRoles();
    }

    @Override
    public RoleEntity getById(int idRole) {
        return roleDao.getRoleById(idRole);
    }

    @Override
    public RoleEntity insert(RoleEntity newRole) {
        return roleDao.insertRole(newRole);
    }

    @Override
    public RoleEntity update(RoleEntity updateRole) {
        return roleDao.updateRole(updateRole);
    }

    @Override
    public RoleEntity delete(RoleEntity role) {
        return roleDao.delete(role);
    }
}
