package ar.com.heroes.services.staff;

import ar.com.heroes.config.BcryptGenerator;
import ar.com.heroes.model.dao.staff.IStaffDao;
import ar.com.heroes.model.domain.role.RoleEntity;
import ar.com.heroes.model.domain.staff.StaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by nlosada on 15/05/18.
 */
@Service("staffServiceImpl")
@Transactional
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private IStaffDao staffDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StaffEntity staff = staffDao.findByEmail(email);
        if (staff == null){
            throw new UsernameNotFoundException("Invalid staffname or password.");
        }
        return new org.springframework.security.core.userdetails.User(staff.getEmail(),
                staff.getPassword(),
                mapRolesToAuthorities(staff.getRoles()));
    }



    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<RoleEntity> roles){
        Collection<? extends GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getKey()))
                .collect(Collectors.toList());
        return authorities;
    }


    @Override
    public StaffEntity findByEmail(String email) {
        return staffDao.get(email);
    }

    @Override
    public List<StaffEntity> getAll() {
        return staffDao.getStaff();
    }


    @Override
    public StaffEntity get(String email) {
        return staffDao.get(email);
    }

    @Override
    public StaffEntity getById(int idStaff) {
        return staffDao.getStaffById(idStaff);
    }

    @Override
    public StaffEntity insert(StaffEntity newStaff) {
        newStaff.setPassword(BcryptGenerator.getCodedPass(newStaff.getPassword()));
        return staffDao.insertStaff(newStaff);
    }

    @Override
    public StaffEntity update(StaffEntity updateStaff) {
        updateStaff.setPassword(BcryptGenerator.getCodedPass(updateStaff.getPassword()));
        return staffDao.updateStaff(updateStaff);
    }

    @Override
    public StaffEntity delete(StaffEntity staff) {
        return staffDao.delete(staff);
    }

}
