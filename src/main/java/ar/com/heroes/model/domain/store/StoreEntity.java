package ar.com.heroes.model.domain.store;

import ar.com.heroes.model.domain.address.AddressEntity;
import ar.com.heroes.model.domain.staff.StaffEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nlosada on 29/09/18.
 */
@Entity
@Table(name = "store", schema = "public", catalog = "dvdrental")
public class StoreEntity {
    private int storeId;
    /*private short managerStaffId;
    private short addressId;*/
    private Timestamp lastUpdate;
    private StaffEntity managerStaff;
    private AddressEntity address;

    @Id
    @Column(name = "store_id", nullable = false)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /*@Basic
    @Column(name = "manager_staff_id", nullable = false)
    public short getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(short managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    @Basic
    @Column(name = "address_id", nullable = false)
    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }*/

    @Basic
    @Column(name = "last_update", nullable = false)
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (storeId != that.storeId) return false;
        if (managerStaffId != that.managerStaffId) return false;
        if (addressId != that.addressId) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }*/

    /*@Override
    public int hashCode() {
        int result = storeId;
        result = 31 * result + (int) managerStaffId;
        result = 31 * result + (int) addressId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }*/

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    public StaffEntity getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(StaffEntity managerStaff) {
        this.managerStaff = managerStaff;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
