//package com.Java_Training.Product_Management.KeycloakSecurity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRequest {
//	private String username;
//	private String email;
//	private String firstName;
//	private String lastName;
//	private boolean enabled;
//	private List<Credential> credentials;
//	private List<String> realmRoles;
//
//	public UserRequest() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public UserRequest(String email, String firstName, String lastName, String password) {
//
////		creating Credential
//		List<Credential> credentials = new ArrayList<>();
//		Credential credential = CreateCredential.createCredential(password);
//		credentials.add(credential);
//
//		List<String> roles = new ArrayList<>();
//		roles.add("admin");
//
//		this.username = email;
//		this.email = email;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.enabled = true;
//		this.credentials = credentials;
//		this.realmRoles = roles;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	public List<Credential> getCredentials() {
//		return credentials;
//	}
//
//	public void setCredentials(List<Credential> credentials) {
//		this.credentials = credentials;
//	}
//
//	public List<String> getRealmRoles() {
//		return realmRoles;
//	}
//
//	public void setRoles(List<String> realmRoles) {
//		this.realmRoles = realmRoles;
//	}
//
//	@Override
//	public String toString() {
//		return "UserRequest [username=" + username + ", email=" + email + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", enabled=" + enabled + ", credentials=" + credentials + ", realmRoles=" + realmRoles + "]";
//	}
//
//}
