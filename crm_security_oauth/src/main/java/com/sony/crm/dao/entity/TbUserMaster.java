package com.sony.crm.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_USER_MASTER")
public class TbUserMaster implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1750445018392687857L;
	@Id	
private int id;
@Column(name = "USER_NAME")
private String userName;
@Column(name = "PASSWORD")
private String password;
@Column(name = "ROLES")
private String roles ;
@Column(name = "LAST_LOGIN_TIME")
@Temporal(TemporalType.TIMESTAMP)
private Date lastLoginDateTime;
@Column(name = "ENABLED")
private boolean enabled;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRoles() {
	return roles;
}
public void setRoles(String roles) {
	this.roles = roles;
}
public Date getLastLoginDateTime() {
	return lastLoginDateTime;
}
public void setLastLoginDateTime(Date lastLoginDateTime) {
	this.lastLoginDateTime = lastLoginDateTime;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

}
