package ar.com.heroes.services.staff;

import ar.com.heroes.model.domain.staff.StaffEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by nlosada on 29/06/18.
 */
public interface IStaffService {
   /* @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;*/
    StaffEntity findByEmail(String email);

    List<StaffEntity> getAll();
    StaffEntity getById(int idStaff);
    StaffEntity get(String email);
    StaffEntity insert(StaffEntity newStaff);
    StaffEntity update(StaffEntity updateStaff);
    StaffEntity delete(StaffEntity staff);
}
