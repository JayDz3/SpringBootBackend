package com.jaydz.javaspringbootrest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table
public class User {

	private @Id @GeneratedValue Long id;
	private @NotNull String firstName;
	private String lastName;
	private @Column(unique=true) String email;
	private String password;
	private boolean emailConfirmed, isLoggedIn, stayLoggedIn, active;
	private String created;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	
	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	public void setStayLoggedIn(boolean stayLoggedIn) {
		this.stayLoggedIn = stayLoggedIn;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}

	public boolean getActive() {
		return this.active;
	}
	
	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public boolean getIsLoggedIn() {
		return this.isLoggedIn;
	}
	
	public boolean getStayLoggedIn() {
		return this.stayLoggedIn;
	}
	
	public String getCreated() {
		return this.created;
	}
}
