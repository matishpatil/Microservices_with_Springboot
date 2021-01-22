package com.appdeveloperblog.app.ws.ui.model.reuest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsReuestModel {

	@NotNull(message="FirstName can not be empty/null")
	@Size(min=3, message="Firstname can not be less than 3 characters")
	private String firstName;
	
	@NotNull(message="LastName can not be empty/null")
	@Size(min=3, message="Lastname can not be less than 3 characters")
	private String lastName;
	
	@NotNull(message="Email can not be empty/null")
	@Email
	private String email;
	
	@NotNull(message="Password can not be empty/null")
	@Size(min=8, max=16, message="Password must be greater than 8 characters and less tan 16 characters.")
	private String password;
	
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
}
