package com.thalesbensi.To_Do_List.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.thalesbensi.To_Do_List.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String login;
	
	private String password;
	
	private UserRole role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return login;
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


}