package ar.com.heroes.model.domain.country;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nlosada on 18/04/18.
 */
@Entity
@Table(name = "country", schema = "public", catalog = "dvdrental")
public class CountryEntity {
    private int countryId;
    private String country;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "last_update", nullable = false)
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (countryId != that.countryId) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
