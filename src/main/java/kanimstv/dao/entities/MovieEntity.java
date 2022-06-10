package kanimstv.dao.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "movie")
public class MovieEntity {
    
    @Id
    @SequenceGenerator(name = "movie_id_seq", sequenceName = "movie_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_seq")
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String trailer;

    @Column
    private String duration;

    @Column
    private String releasedDate;

    @Column
    private byte[] bill;

    @Column
    private String ageLimit;

    @Column
    private String mark;


    public MovieEntity() {
    }

    public MovieEntity(int id, String name, String description, String trailer, String duration, String releasedDate, byte[] bill, String ageLimit, String mark) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.releasedDate = releasedDate;
        this.bill = bill;
        this.ageLimit = ageLimit;
        this.mark = mark;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleasedDate() {
        return this.releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public byte[] getBill() {
        return this.bill;
    }

    public void setBill(byte[] bill) {
        this.bill = bill;
    }

    public String getAgeLimit() {
        return this.ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public MovieEntity id(int id) {
        setId(id);
        return this;
    }

    public MovieEntity name(String name) {
        setName(name);
        return this;
    }

    public MovieEntity description(String description) {
        setDescription(description);
        return this;
    }

    public MovieEntity duration(String duration) {
        setDuration(duration);
        return this;
    }

    public MovieEntity releasedDate(String releasedDate) {
        setReleasedDate(releasedDate);
        return this;
    }

    public MovieEntity bill(byte[] bill) {
        setBill(bill);
        return this;
    }

    public MovieEntity ageLimit(String ageLimit) {
        setAgeLimit(ageLimit);
        return this;
    }

    public MovieEntity mark(String mark) {
        setMark(mark);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MovieEntity)) {
            return false;
        }
        MovieEntity movieEntity = (MovieEntity) o;
        return id == movieEntity.id && Objects.equals(name, movieEntity.name) && Objects.equals(description, movieEntity.description) && Objects.equals(trailer, movieEntity.trailer) && Objects.equals(duration, movieEntity.duration) && Objects.equals(releasedDate, movieEntity.releasedDate) && Objects.equals(bill, movieEntity.bill) && Objects.equals(ageLimit, movieEntity.ageLimit) && Objects.equals(mark, movieEntity.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, trailer, duration, releasedDate, bill, ageLimit, mark);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", trailer='" + getTrailer() + "'" +
            ", duration='" + getDuration() + "'" +
            ", releasedDate='" + getReleasedDate() + "'" +
            ", bill='" + getBill() + "'" +
            ", ageLimit='" + getAgeLimit() + "'" +
            ", mark='" + getMark() + "'" +
            "}";
    }

}
