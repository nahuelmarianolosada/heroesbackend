package ar.com.heroes.model.domain.actor;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by nlosada on 06/05/18.
 */


@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getActorsInfo",
                query = "SELECT t.actor_id as actor_id, " +
                        "t.first_name as first_name," +
                        "t.last_name as last_name," +
                        "t.film_info as film_info " +
                        "FROM actor_info t",
                resultClass = ActorInfoEntity.class
        ),
        @NamedNativeQuery(
                name = "getActorInfo",
                query = "SELECT t.actor_id as actor_id, " +
                "t.first_name as first_name," +
                "t.last_name as last_name," +
                "t.film_info as film_info " +
                "FROM actor_info t " +
                "WHERE actor_id = :id",
                resultClass = ActorInfoEntity.class)
})
@Entity

/*
@NamedNativeQuery(name = "getActorsInfo", query = "SELECT t.actor_id as actor_id, " +
        "t.first_name as first_name," +
        "t.last_name as last_name," +
        "t.film_info as film_info " +
        "FROM actor_info t",
        resultClass = ActorInfoEntity.class)*/

/*@NamedNativeQuery(name = "getInfo", query = "SELECT t.actor_id as actor_id, " +
        "t.first_name as first_name," +
        "t.last_name as last_name," +
        "t.film_info as film_info " +
        "FROM actor_info t " +
        "WHERE actor_id = :id",
        resultClass = ActorInfoEntity.class)*/
public class ActorInfoEntity implements Serializable {

    private int actorId;
    private String firstName;
    private String lastName;
    private String filmInfo;
    private Timestamp lastUpdate;



    @Id
    @Column(name = "actor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
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
    @Column(name = "film_info", nullable = false, length = 500)
    public String getFilmInfo() {
        return this.filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
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

        ActorInfoEntity that = (ActorInfoEntity) o;

        if (actorId != that.actorId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }


}
