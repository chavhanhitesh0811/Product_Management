package com.Java_Training.Product_Management.exceptions;

public class InternalServerException extends Exception {
	private static final long serialVersionUID = 1L;

	public InternalServerException(String message) {
		super(message);
	}
}
