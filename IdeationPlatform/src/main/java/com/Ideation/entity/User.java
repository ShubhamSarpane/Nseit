package com.Ideation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	
	
	
	private String userName;
	@Id
	private long empId;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	private String role;
	private boolean enabled;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, long empId, String email, String password, String role, boolean enabled) {
		super();
		this.userName = userName;
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", empId=" + empId + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	
	
	
	
	
	
 

}
