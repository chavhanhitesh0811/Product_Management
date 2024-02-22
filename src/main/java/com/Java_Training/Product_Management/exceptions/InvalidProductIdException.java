package com.Java_Training.Product_Management.exceptions;

public class InvalidProductIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidProductIdException(String message) {
		super(message);
	}
}
