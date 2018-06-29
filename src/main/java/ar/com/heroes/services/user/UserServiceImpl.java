package ar.com.heroes.services.user;

import ar.com.heroes.model.dao.user.IUserDao;
import ar.com.heroes.model.domain.role.UserRoleEntity;
import ar.com.heroes.model.domain.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by nlosada on 15/05/18.
 */
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;


    /*private BCryptPasswordEncoder passwordEncoder;


    public void save(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
                mapRolesToAuthorities(user.getUserRolesById()));
    }



    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRoleEntity> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleByIdRole().getKey()))
                .collect(Collectors.toList());
    }

}
