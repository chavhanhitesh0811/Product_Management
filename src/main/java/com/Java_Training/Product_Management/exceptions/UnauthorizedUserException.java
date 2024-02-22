package com.Java_Training.Product_Management.exceptions;

public class UnauthorizedUserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UnauthorizedUserException(String message) {
		super(message);
	}
}
