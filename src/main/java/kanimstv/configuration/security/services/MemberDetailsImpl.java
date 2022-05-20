package kanimstv.configuration.security.services;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kanimstv.dao.entities.MemberIncubatorEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private int id;
    private String pseudonyme;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    public MemberDetailsImpl(int id, String pseudonyme, String email, String password,
                             Collection<? extends GrantedAuthority> authorities) {
	this.id = id;
	this.pseudonyme = pseudonyme;
	this.email = email;
	this.password = password;
	this.authorities = authorities;
    }
    public static MemberDetailsImpl build(MemberIncubatorEntity member) {
	List<GrantedAuthority> authorities = member.getRolesPermission().stream()
		.map(role -> new SimpleGrantedAuthority(role.getName()))
		.collect(Collectors.toList());
	return new MemberDetailsImpl(
		member.getId(), 
		member.getPseudonyme(),
		member.getEmail(),
		member.getPassword(), 
		authorities);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
	return authorities;
    }
    public int getId() {
	return id;
    }
    public String getEmail() {
	return email;
    }

    public String getPseudonyme() {
	return pseudonyme;
    }

    @Override
    public String getUsername() {

	return email;
    }
    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }
    @Override
    public boolean isAccountNonLocked() {
	return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }
    @Override
    public boolean isEnabled() {
	return true;
    }
    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	MemberDetailsImpl user = (MemberDetailsImpl) o;
	return Objects.equals(id, user.id);
    }


}
