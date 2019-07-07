package com.sony.crm.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.sony.crm.dao.entity.TbUserMaster;

public class SecurityUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8825399037014103670L;
	private TbUserMaster tbUserMaster;
	public  SecurityUser(TbUserMaster tbUserMaster) {
		this.tbUserMaster= tbUserMaster;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(tbUserMaster.getRoles());
	}

	@Override
	public String getPassword() {
		return tbUserMaster.getPassword();
	}

	@Override
	public String getUsername() {
		return tbUserMaster.getUserName();
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
		return tbUserMaster.isEnabled();
	}

}
