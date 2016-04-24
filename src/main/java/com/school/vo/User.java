package com.school.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends ValueObject {
	private String password;
	private String userName;
	private int roleId;
	private boolean active;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public User() {

	}

	public User(String password, String userName, int roleId, boolean active, Date creationDate, Date updatedDate) {
		super();
		this.password = password;
		this.userName = userName;
		this.roleId = roleId;
		this.active = active;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
