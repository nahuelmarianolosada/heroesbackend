package ar.com.heroes.model.dao.user;

import ar.com.heroes.model.domain.user.UserEntity;

import java.util.List;

/**
 * Created by nlosada on 15/05/18.
 */
public interface IUserDao {
    UserEntity findByEmail(String email);
   /* UserEntity save(UserEntity user);*/


    UserEntity insertUser(UserEntity actor);

    UserEntity updateUser(UserEntity actor);

    UserEntity delete(UserEntity actor);

    UserEntity getUserById(int actorId);

    List<UserEntity> getUsers();
}
