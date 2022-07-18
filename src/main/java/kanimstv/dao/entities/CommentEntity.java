package kanimstv.dao.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "comment")
public class CommentEntity {
    
    @Id
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_is_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
    private int id;

    @Column(nullable = true)
    private String domain;

    @Column(nullable = true)
    private String path;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private Date createdAt;

    public CommentEntity() {
    }

    public CommentEntity(int id, String domain, String path, String name, String email, Date createdAt, Date updatedAt) {
        this.id = id;
        this.domain = domain;
        this.path = path;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CommentEntity id(int id) {
        setId(id);
        return this;
    }

    public CommentEntity domain(String domain) {
        setDomain(domain);
        return this;
    }

    public CommentEntity path(String path) {
        setPath(path);
        return this;
    }

    public CommentEntity name(String name) {
        setName(name);
        return this;
    }

    public CommentEntity email(String email) {
        setEmail(email);
        return this;
    }

    public CommentEntity createdAt(Date createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public CommentEntity updatedAt(Date updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentEntity)) {
            return false;
        }
        CommentEntity commentEntity = (CommentEntity) o;
        return id == commentEntity.id && Objects.equals(domain, commentEntity.domain) && Objects.equals(path, commentEntity.path) && Objects.equals(name, commentEntity.name) && Objects.equals(email, commentEntity.email) && Objects.equals(createdAt, commentEntity.createdAt) && Objects.equals(updatedAt, commentEntity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domain, path, name, email, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", domain='" + getDomain() + "'" +
            ", path='" + getPath() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }

    @Column(nullable = true)
    private Date updatedAt;


}
