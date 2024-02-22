package com.Java_Training.Product_Management.utils;

import java.util.NoSuchElementException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Java_Training.Product_Management.exceptions.NoProductFoundException;
import com.Java_Training.Product_Management.exceptions.InvalidProductIdException;
import com.Java_Training.Product_Management.exceptions.InternalServerException;
import com.Java_Training.Product_Management.exceptions.LoginFailedException;
import com.Java_Training.Product_Management.exceptions.InvalidRquestFieldException;
import com.Java_Training.Product_Management.exceptions.UnauthorizedUserException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//	---------------------------------------- Handle Custom exceptions ------------------------------------------

	@ExceptionHandler(NoProductFoundException.class)
	public ResponseEntity<Object> NoProductFoundException(NoProductFoundException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", ex.getMessage()));
	}

	@ExceptionHandler(InvalidProductIdException.class)
	public ResponseEntity<Object> InvalidProductIdException(InvalidProductIdException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", ex.getMessage()));
	}

	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<Object> InternalServerException(InternalServerException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", ex.getMessage()));
	}

	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<Object> LoginFailedException(LoginFailedException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", ex.getMessage()));
	}

	@ExceptionHandler(InvalidRquestFieldException.class)
	public ResponseEntity<Object> InvalidRquestFieldException(InvalidRquestFieldException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", ex.getMessage()));
	}

	@ExceptionHandler(UnauthorizedUserException.class)
	public ResponseEntity<Object> UnauthorizedUserException(UnauthorizedUserException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(401, "FAILED", ex.getMessage()));
	}

//	---------------------------------------- Handle predefined exceptions ------------------------------------------
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> NoSuchElementException(NoSuchElementException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", "Bad Request"));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", errorMessage));
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Object> UnexpectedTypeException(UnexpectedTypeException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", ex.getMessage()));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> HttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "FAILED", "Bad Request"));
	}
}
