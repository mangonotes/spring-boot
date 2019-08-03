package org.sony.jpa.demo.dao.enitty;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "TB_CUST_MASTER")
@NamedQuery(name = "TbCustMaster.findAllCustmerByDescending",
query = "SELECT c.userName as userName, c.firstName as firstName FROM TbCustMaster c where c.id=?1 ORDER BY c.userName DESC" )
public class TbCustMaster {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "USER_EMAIL")
	private String userEmail;
	@Column(name = "DOJ")
	@Temporal(TemporalType.DATE)
	private Date doj;
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDt;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	@Column(name = "MODIFIED_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDt;

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@PrePersist
	public void addCreatedDt()
	{
		createdDt = new Date();
	}
	@PreUpdate
	public void updateModifiedDate()
	{
		modifiedDt = new Date();
	}
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public TbCustMaster(int id, String createdBy) {
		super();
		this.id = id;
		this.createdBy = createdBy;
	}
	public TbCustMaster()
	{
		super();
	}

	public TbCustMaster(String userName, String firstName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
	}
	

}
