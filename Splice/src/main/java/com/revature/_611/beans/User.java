package com.revature._611.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 2016/12/01
 * User bean for first sprint of Project 2: Splice Game. <br>
 * Using: Hibernate, Serializable <br>
 * Overrides: toString(), hashCode(), equals()
 * 
 * @author Ric Smith
 * @version 1.0
 */
@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = 6833446773570802563L;
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	public User() { super(); }

	public User(int userId, String username, String password) 
	{
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() 
	{
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}//Bean User
