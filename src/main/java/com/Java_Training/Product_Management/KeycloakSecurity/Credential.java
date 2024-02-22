package com.Java_Training.Product_Management.KeycloakSecurity;

public class Credential {
	private String type;
	private String value;
	private boolean temporary;

	public Credential() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credential(String password) {
		super();
		this.type = "password";
		this.value = password;
		this.temporary = false;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isTemporary() {
		return temporary;
	}

	public void setTemporary(boolean temporary) {
		this.temporary = temporary;
	}

	@Override
	public String toString() {
		return "Credential [type=" + type + ", value=" + value + ", temporary=" + temporary + "]";
	}

}