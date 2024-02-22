package com.Java_Training.Product_Management.KeycloakSecurity;

public class CreateCredential {

	public static Credential createCredential(String password) {
		Credential credential = new Credential(password);
		return credential;
	}
}
