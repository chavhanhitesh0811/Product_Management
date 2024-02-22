package com.Java_Training.Product_Management.utils;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {

	private int statusCodeValue;

	private String statusCode;

	private String message;

	public ErrorResponse(int statusCodeValue, String statusCode, String message) {
		super();
		this.statusCodeValue = statusCodeValue;
		this.statusCode = statusCode;
		this.message = message;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatusCodeValue() {
		return statusCodeValue;
	}

	public void setStatusCodeValue(int statusCodeValue) {
		this.statusCodeValue = statusCodeValue;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
