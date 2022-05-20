package kanimstv.dto;

import java.util.Set;

public class MemberIncubatorDto {

    private int id;
    private String pseudonyme;
    private RoleMemberDto role;
    private String email;
    private String phoneNumber;
    private Boolean isOldMember;
    private String password;
    private Set<RolePermissionDto> rolesPermission;


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

    public RoleMemberDto getRole() {
        return this.role;
    }

    public void setRole(RoleMemberDto role) {
        this.role = role;
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

    public Set<RolePermissionDto> getRolesPermission() {
        return this.rolesPermission;
    }

    public void setRolesPermission(Set<RolePermissionDto> rolesPermission) {
        this.rolesPermission = rolesPermission;
    }



}
