package com.appsdevloperblog.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	
	@NotNull(message="FirstName cannot be null.")
	@Size(min=3, message="Please enter 3 or more characters.")
	private String firstName;
	
	@NotNull(message="LastName cannot be null.")
	@Size(min=3, message="Please enter 3 or more characters.")
	private String lastName;
	
	@NotNull(message="Password cannot be null.")
	@Size(min=8, max=16, message="Please enter 8 or more characters and less than 16 characters.")
	private String password;
	
	@NotNull
	@Email
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
