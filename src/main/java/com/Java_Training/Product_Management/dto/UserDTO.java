package com.Java_Training.Product_Management.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty(message = "Please enter a valid name.")
	private String name;

	@NotEmpty(message = "Please enter a valid email")
	private String email;

	@NotEmpty(message = "Please enter a valid password")
	private String password;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(@NotEmpty(message = "Please enter a valid name.") String name,
			@NotEmpty(message = "Please enter a valid email") String email,
			@NotEmpty(message = "Please enter a valid password") String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
