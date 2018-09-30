package ar.com.heroes.model.domain.payment;

import ar.com.heroes.model.domain.rental.RentalEntity;
import ar.com.heroes.model.domain.staff.StaffEntity;
import ar.com.heroes.model.domain.customer.CustomerEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by nlosada on 29/09/18.
 */
@Entity
@Table(name = "payment", schema = "public", catalog = "dvdrental")
public class PaymentEntity {
    private int paymentId;
    private BigDecimal amount;
    private Timestamp paymentDate;
    private CustomerEntity customerByCustomerId;
    private StaffEntity staffByStaffId;
    private RentalEntity rentalByRentalId;

    @Id
    @Column(name = "payment_id", nullable = false)
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "payment_date", nullable = false)
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (paymentId != that.paymentId) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (paymentDate != null ? !paymentDate.equals(that.paymentDate) : that.paymentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    public StaffEntity getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(StaffEntity staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "rental_id", nullable = false)
    public RentalEntity getRentalByRentalId() {
        return rentalByRentalId;
    }

    public void setRentalByRentalId(RentalEntity rentalByRentalId) {
        this.rentalByRentalId = rentalByRentalId;
    }
}
