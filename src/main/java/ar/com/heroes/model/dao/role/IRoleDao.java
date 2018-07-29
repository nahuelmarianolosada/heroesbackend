package ar.com.heroes.model.dao.role;

import ar.com.heroes.model.domain.role.RoleEntity;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */
public interface IRoleDao {

    RoleEntity insertRole(RoleEntity role);

    RoleEntity updateRole(RoleEntity role);

    RoleEntity delete(RoleEntity role);

    RoleEntity getRoleById(int roleId);

    List<RoleEntity> getRoles();
}
