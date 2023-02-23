package com.healthify.api.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.healthify.api.entity.Role;


public class CustomUserDetail implements UserDetails {

	private String userid;
	private String password;

	private Set<Role> roles;

	public CustomUserDetail() {
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetail(String userid, String password, Set<Role> roles) {
		super();
		this.userid = userid;
		this.password = password;
		this.roles = roles;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<SimpleGrantedAuthority> autorities = this.roles.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return autorities;

	}

	@Override
	public String getUsername() {
		return this.userid;
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
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String toString() {
		return "CustomUserDetail [userid=" + userid + ", password=" + password + ", roles=" + roles + "]";
	}
	
	

}
