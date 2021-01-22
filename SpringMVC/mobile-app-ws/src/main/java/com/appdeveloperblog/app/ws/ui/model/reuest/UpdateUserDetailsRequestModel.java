package com.appdeveloperblog.app.ws.ui.model.reuest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotNull(message="FirstName can not be empty/null")
	@Size(min=3, message="Firstname can not be less than 3 characters")
	private String firstName;
	
	@NotNull(message="LastName can not be empty/null")
	@Size(min=3, message="Lastname can not be less than 3 characters")
	private String lastName;
	
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
}
