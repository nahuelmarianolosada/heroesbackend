package ar.com.heroes.services.role;

import ar.com.heroes.model.domain.role.RoleEntity;

import java.util.List;

/**
 * Created by nlosada on 24/07/18.
 */
public interface IRoleService {
    List<RoleEntity> getAll();
    RoleEntity getById(int idRole);
    RoleEntity insert(RoleEntity newRole);
    RoleEntity update(RoleEntity updateRole);
    RoleEntity delete(RoleEntity role);
}
