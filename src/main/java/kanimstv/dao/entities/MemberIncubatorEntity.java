package kanimstv.dao.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "member_incubator")
public class MemberIncubatorEntity {

    @Id
    @SequenceGenerator(name = "member_incubator_id_seq", sequenceName = "member_incubator_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_incubator_id_seq")
    private int id;

    @Column(nullable = true)
    private String pseudonyme;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private Boolean isOldMember;

    @Column(nullable = true)
    private String password;

    @ManyToMany
    @JoinTable(
      name = "members_role_permission",
      joinColumns = @JoinColumn(name = "member_incubator_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_permission_id", referencedColumnName = "id")
    )
    private Set<RolePermissionEntity> rolesPermission;


    public MemberIncubatorEntity(String pseudonyme, String email, String phoneNumber, Boolean isOldMember, String password) {
        this.pseudonyme = pseudonyme;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isOldMember = isOldMember;
        this.password = password;
    }


    public MemberIncubatorEntity() {
    }

    public MemberIncubatorEntity(int id, String pseudonyme, String email, String phoneNumber, Boolean isOldMember) {
        this.id = id;
        this.pseudonyme = pseudonyme;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isOldMember = isOldMember;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudonyme() {
        return this.pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean isIsOldMember() {
        return this.isOldMember;
    }

    public Boolean getIsOldMember() {
        return this.isOldMember;
    }

    public void setIsOldMember(Boolean isOldMember) {
        this.isOldMember = isOldMember;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RolePermissionEntity> getRolesPermission() {
        return this.rolesPermission;
    }

    public void setRolesPermission(Set<RolePermissionEntity> rolesPermission) {
        this.rolesPermission = rolesPermission;
    }

    public MemberIncubatorEntity id(int id) {
        setId(id);
        return this;
    }

    public MemberIncubatorEntity pseudonyme(String pseudonyme) {
        setPseudonyme(pseudonyme);
        return this;
    }

    public MemberIncubatorEntity email(String email) {
        setEmail(email);
        return this;
    }

    public MemberIncubatorEntity phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public MemberIncubatorEntity isOldMember(Boolean isOldMember) {
        setIsOldMember(isOldMember);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MemberIncubatorEntity)) {
            return false;
        }
        MemberIncubatorEntity memberIncubatorEntity = (MemberIncubatorEntity) o;
        return id == memberIncubatorEntity.id && Objects.equals(pseudonyme, memberIncubatorEntity.pseudonyme) && Objects.equals(email, memberIncubatorEntity.email) && Objects.equals(phoneNumber, memberIncubatorEntity.phoneNumber) && Objects.equals(isOldMember, memberIncubatorEntity.isOldMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pseudonyme, email, phoneNumber, isOldMember,password, rolesPermission);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", pseudonyme='" + getPseudonyme() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", isOldMember='" + isIsOldMember() + "'" +
            ", rolesPermission='" + getRolesPermission() + "'" +
            "}";
    }

    
}
