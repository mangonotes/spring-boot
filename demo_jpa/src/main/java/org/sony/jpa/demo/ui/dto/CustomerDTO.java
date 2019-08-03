package org.sony.jpa.demo.ui.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
private String firstName;
private String lastName;
private String userEmail;
private Date doj;
private Date createdDate;
private String userName;
private int id;
private String createdBy;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public CustomerDTO(String firstName, String lastName, Date doj, Date createdDate, String userName, int id) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.doj = doj;
	this.createdDate = createdDate;
	this.userName = userName;
	this.id = id;
}

public String getCreatedBy() {
	return createdBy;
}
public CustomerDTO()
{
	super();
}
public CustomerDTO(String firstName, String userName)
{
	super();
	this.firstName= firstName;
	this.userName= userName;
	
}
public CustomerDTO(String createdBy, int id)
{
	this.createdBy = createdBy;
	this.id= id;
}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
