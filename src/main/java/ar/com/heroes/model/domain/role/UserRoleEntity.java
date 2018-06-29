package ar.com.heroes.model.domain.role;

import ar.com.heroes.model.domain.user.UserEntity;

import javax.persistence.*;

/**
 * Created by nlosada on 15/05/18.
 */
@Entity
@Table(name = "user_role", schema = "public", catalog = "dvdrental")
public class UserRoleEntity {
    private int id;
    private UserEntity userByIdUser;
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

        UserRoleEntity that = (UserRoleEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
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
