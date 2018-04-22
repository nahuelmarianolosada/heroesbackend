package ar.com.heroes.model.domain.city;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nlosada on 18/04/18.
 */
@Entity
@Table(name = "city", schema = "public", catalog = "dvdrental")
public class CityEntity {
    private int cityId;
    private String city;
    private short countryId;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country_id", nullable = false)
    public short getCountryId() {
        return countryId;
    }

    public void setCountryId(short countryId) {
        this.countryId = countryId;
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

        CityEntity that = (CityEntity) o;

        if (cityId != that.cityId) return false;
        if (countryId != that.countryId) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (int) countryId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
