package ar.com.heroes.model.domain.user;

import ar.com.heroes.model.domain.role.RoleEntity;
import ar.com.heroes.model.domain.store.StoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nlosada on 15/05/18.
 */
@Entity
@Table(name = "USER", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String pass;
    private StoreEntity store;
    private boolean active;
    private String username;
    private Timestamp lastUpdate;
    private String img;


    Set<RoleEntity> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") })
    public Set<RoleEntity> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }





    @Id
    @Column(name = "id", unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pass", length = 500)
    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    @Basic
    @Column(name = "active", nullable = true)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "username", length = 20, nullable = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "img", length = 1000)
    public String getImg() {
        return img;
    }

    public void setImg(String picture) {
        this.img = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        if (isActive() != that.isActive()) return false;
        if (!getId().equals(that.getId())) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getPass() != null ? !getPass().equals(that.getPass()) : that.getPass() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        if (getLastUpdate() != null ? !getLastUpdate().equals(that.getLastUpdate()) : that.getLastUpdate() != null)
            return false;
        if (getImg() != null ? !getImg().equals(that.getImg()) : that.getImg() != null) return false;
        return getRoles() != null ? getRoles().equals(that.getRoles()) : that.getRoles() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPass() != null ? getPass().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getLastUpdate() != null ? getLastUpdate().hashCode() : 0);
        result = 31 * result + (getImg() != null ? getImg().hashCode() : 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        return result;
    }
}
