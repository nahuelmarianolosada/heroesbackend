package ar.com.heroes.model.dao.staff;

import ar.com.heroes.model.domain.staff.StaffEntity;

import java.util.List;

/**
 * Created by nlosada on 15/05/18.
 */
public interface IStaffDao {
    StaffEntity findByEmail(String email);
   /* StaffEntity save(StaffEntity staff);*/


    StaffEntity insertStaff(StaffEntity staff);

    StaffEntity updateStaff(StaffEntity staff);

    StaffEntity delete(StaffEntity actor);

    StaffEntity getStaffById(int actorId);

    StaffEntity get(String email);

    List<StaffEntity> getStaff();
}
