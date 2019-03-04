package ar.com.heroes.model.domain.role;

import ar.com.heroes.model.domain.user.UserEntity;
import ar.com.heroes.model.domain.userRole.UserRoleEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nlosada on 15/05/18.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "ROLE", schema = "public")
public class RoleEntity {
    private int id;
    private String key;
    private String name;
    private String img;
    /*private Collection<UserRoleEntity> userRolesById;*/

   /* @ManyToMany(mappedBy = "user")
    private Set<UserEntity> users= new HashSet<>();*/

    @Id
    @Column(name = "id", unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "key", nullable = true, length = 30)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "img", nullable = true)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    /* public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }*/


    /* @OneToMany(mappedBy = "roleByIdRole")
    public Collection<UserRoleEntity> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRoleEntity> userRolesById) {
        this.userRolesById = userRolesById;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }

}
