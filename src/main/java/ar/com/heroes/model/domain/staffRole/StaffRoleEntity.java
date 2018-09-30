package ar.com.heroes.model.domain.staffRole;

import ar.com.heroes.model.domain.role.RoleEntity;
import ar.com.heroes.model.domain.staff.StaffEntity;

import javax.persistence.*;

/**
 * Created by nlosada on 29/09/18.
 */
@Entity
@Table(name = "staff_role", schema = "public", catalog = "dvdrental")
public class StaffRoleEntity {
    private int id;
    private StaffEntity staffByIdStaff;
    private RoleEntity roleByIdRole;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffRoleEntity that = (StaffRoleEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "id_staff", referencedColumnName = "staff_id")
    public StaffEntity getStaffByIdStaff() {
        return staffByIdStaff;
    }

    public void setStaffByIdStaff(StaffEntity staffByIdStaff) {
        this.staffByIdStaff = staffByIdStaff;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    public RoleEntity getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(RoleEntity roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}
