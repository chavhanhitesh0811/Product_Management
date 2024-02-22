package com.Java_Training.Product_Management.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SuccessResponse {

	private int statusCodeValue;

	private String statusCode;

	private String message;

	private List<Object> data;

	public SuccessResponse(int statusCodeValue, String statusCode, String message) {
		super();
		this.statusCodeValue = statusCodeValue;
		this.statusCode = statusCode;
		this.message = message;
	}

	public SuccessResponse(int statusCodeValue, String statusCode, String message, List<Object> data) {
		super();
		this.statusCodeValue = statusCodeValue;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public SuccessResponse() {
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

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

}
