package kanimstv.dto;

public class SearchMemberCriteriaDto {

    private String pseudonyme;
    private Boolean isOldMember;
    private Integer roleMemberId;
    
    public String getPseudonyme() {
        return pseudonyme;
    }
    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }
    public Boolean getIsOldMember() {
        return isOldMember;
    }
    public void setIsOldMember(Boolean isOldMember) {
        this.isOldMember = isOldMember;
    }
    public Integer getRoleMemberId() {
        return roleMemberId;
    }
    public void setRoleMemberId(Integer roleMemberId) {
        this.roleMemberId = roleMemberId;
    }
    
    @Override
    public String toString() {
	return "SearchMemberCriteriaDto [pseudonyme=" + pseudonyme + ", isOldMember=" + isOldMember + ", roleMemberId=" + roleMemberId + "]";
    }
}
