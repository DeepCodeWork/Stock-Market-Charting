package com.premium.stc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@NotEmpty
	@Column(name="username",unique = true)
	private String username;
	
	@NotEmpty
	@Column(name="userPassword")
	private String userPassword;
	
	@NotEmpty
	@Column(name="userType")
	private String userType="USER";
	
	@NotEmpty
	@Column(name="userEmail",unique = true)
	private String userEmail;
	
	@NotEmpty
	@Column(name="userMobileNumber",unique = true)
	private String userMobileNumber;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean confirmed=false;
	
	public User()
	{
		this.confirmed=false;
		this.userType="USER";
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String isUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	
	public String getUserType() {
		return userType;
	}
	
}