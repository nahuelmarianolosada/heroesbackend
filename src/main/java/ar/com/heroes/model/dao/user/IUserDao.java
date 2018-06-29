package ar.com.heroes.model.dao.user;

import ar.com.heroes.model.domain.user.UserEntity;

/**
 * Created by nlosada on 15/05/18.
 */
public interface IUserDao {
    UserEntity findByEmail(String email);
    UserEntity save(UserEntity user);
}
