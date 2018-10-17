package ar.com.heroes.model.domain.staff;

import ar.com.heroes.model.domain.role.RoleEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nlosada on 29/09/18.
 */
@Entity
@Table(name = "staff", schema = "public", catalog = "dvdrental")
public class StaffEntity {
    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private short storeId;
    private boolean active;
    private String username;
    private String password;
    private Timestamp lastUpdate;
    private byte[] picture;

    Set<RoleEntity> roles = new HashSet<>();
 /*   private Collection<PaymentEntity> paymentsByStaffId;
    private Collection<RentalEntity> rentalsByStaffId;*/
/*    private AddressEntity addressByAddressId;*/
   /* private Collection<StaffRoleEntity> staffRolesByStaffId;*/
/*    private Collection<StoreEntity> storesByStaffId;*/

    @Id
    @Column(name = "staff_id", nullable = false)
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "store_id", nullable = false)
    public short getStoreId() {
        return storeId;
    }

    public void setStoreId(short storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "last_update", nullable = false)
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "picture", nullable = true)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffEntity that = (StaffEntity) o;

        if (staffId != that.staffId) return false;
        if (storeId != that.storeId) return false;
        if (active != that.active) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) storeId;
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "staff_role", joinColumns = { @JoinColumn(name = "id_staff") },
            inverseJoinColumns = { @JoinColumn(name = "id_role") })
    public Set<RoleEntity> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

   /* @OneToMany(mappedBy = "staffByStaffId")
    public Collection<PaymentEntity> getPaymentsByStaffId() {
        return paymentsByStaffId;
    }

    public void setPaymentsByStaffId(Collection<PaymentEntity> paymentsByStaffId) {
        this.paymentsByStaffId = paymentsByStaffId;
    }*/

   /* @OneToMany(mappedBy = "staffByStaffId")
    public Collection<RentalEntity> getRentalsByStaffId() {
        return rentalsByStaffId;
    }

    public void setRentalsByStaffId(Collection<RentalEntity> rentalsByStaffId) {
        this.rentalsByStaffId = rentalsByStaffId;
    }*/

   /* @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public AddressEntity getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(AddressEntity addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }*/

   /* @OneToMany(mappedBy = "staffByIdStaff")
    public Collection<StaffRoleEntity> getStaffRolesByStaffId() {
        return staffRolesByStaffId;
    }

    public void setStaffRolesByStaffId(Collection<StaffRoleEntity> staffRolesByStaffId) {
        this.staffRolesByStaffId = staffRolesByStaffId;
    }

    @OneToMany(mappedBy = "staffByManagerStaffId")
    public Collection<StoreEntity> getStoresByStaffId() {
        return storesByStaffId;
    }

    public void setStoresByStaffId(Collection<StoreEntity> storesByStaffId) {
        this.storesByStaffId = storesByStaffId;
    }*/
}
