package com.newewebsite.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table
public class UserDetails {
	
	@Id
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String repeatpwd;
	private String email;
	private Date dateofbirth;
	private Date createdatetime;
	
	
	public UserDetails() {
		
	}
	
	
	
	public UserDetails(String firstname, String lastname, String username, String password, String repeatpwd,
			String email, Date createdatetime) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.repeatpwd = repeatpwd;
		this.email = email;
		this.createdatetime = createdatetime;
	}



	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getRepeatpwd() {
		return repeatpwd;
	}
	public void setRepeatpwd(String repeatpwd) {
		this.repeatpwd = repeatpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	
	

}
