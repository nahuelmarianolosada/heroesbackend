package ar.com.heroes.services.user;

import ar.com.heroes.model.domain.actor.ActorEntity;
import ar.com.heroes.model.domain.actor.ActorInfoEntity;
import ar.com.heroes.model.domain.user.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by nlosada on 29/06/18.
 */
public interface IUserService /*extends UserDetailsService*/ {
   /* @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;*/
    UserEntity findByEmail(String email);

    List<UserEntity> getAll();
    UserEntity getById(int idUser);
    UserEntity insert(UserEntity newUser);
    UserEntity update(UserEntity updateUser);
    UserEntity delete(UserEntity user);
}
