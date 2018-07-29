package ar.com.heroes.services.user;

import ar.com.heroes.config.BcryptGenerator;
import ar.com.heroes.model.dao.user.IUserDao;
import ar.com.heroes.model.domain.role.RoleEntity;
import ar.com.heroes.model.domain.user.UserEntity;
import ar.com.heroes.model.domain.userRole.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by nlosada on 15/05/18.
 */
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

   /* public void save(UserEntity user){

        userDao.save(user);
    }*/

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userDao.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }



    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<RoleEntity> roles){
        Collection<? extends GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getKey()))
                .collect(Collectors.toList());
        return authorities;
    }


    @Override
    public UserEntity findByEmail(String email) {
       return userDao.findByEmail(email);
    }

    @Override
    public List<UserEntity> getAll() {

        return userDao.getUsers();
    }

    @Override
    public UserEntity getById(int idUser) {
        return userDao.getUserById(idUser);
    }

    @Override
    public UserEntity insert(UserEntity newUser) {
        newUser.setPassword(BcryptGenerator.getCodedPass(newUser.getPassword()));
        return userDao.insertUser(newUser);
    }

    @Override
    public UserEntity update(UserEntity updateUser) {
        return userDao.updateUser(updateUser);
    }

    @Override
    public UserEntity delete(UserEntity user) {
        return userDao.delete(user);
    }

}
