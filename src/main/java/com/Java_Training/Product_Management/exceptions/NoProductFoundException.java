package com.Java_Training.Product_Management.exceptions;

public class NoProductFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoProductFoundException(String message) {
		super(message);
	}
}
