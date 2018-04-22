package ar.com.heroes.model.domain.category;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nlosada on 18/04/18.
 */
@Entity
@Table(name = "category", schema = "public", catalog = "dvdrental")
public class CategoryEntity {
    private int categoryId;
    private String name;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        CategoryEntity that = (CategoryEntity) o;

        if (categoryId != that.categoryId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
