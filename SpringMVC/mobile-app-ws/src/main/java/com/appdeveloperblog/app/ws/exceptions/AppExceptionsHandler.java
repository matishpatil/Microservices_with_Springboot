package com.appdeveloperblog.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appdeveloperblog.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest reuest){
		String errorMessageDescription = ex.getLocalizedMessage();
		if(errorMessageDescription == null) errorMessageDescription = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/*
	 * @ExceptionHandler(value = {NullPointerException.class}) public
	 * ResponseEntity<Object> handleNullPOinterException(NullPointerException ex,
	 * WebRequest reuest){ String errorMessageDescription =
	 * ex.getLocalizedMessage(); if(errorMessageDescription == null)
	 * errorMessageDescription = ex.toString(); ErrorMessage errorMessage = new
	 * ErrorMessage(new Date(), errorMessageDescription);
	 * 
	 * return new ResponseEntity<Object>(errorMessage, new HttpHeaders(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * @ExceptionHandler(value = {UserServiceException.class}) public
	 * ResponseEntity<Object> handleUserPOinterException(UserServiceException ex,
	 * WebRequest reuest){ String errorMessageDescription =
	 * ex.getLocalizedMessage(); if(errorMessageDescription == null)
	 * errorMessageDescription = ex.toString(); ErrorMessage errorMessage = new
	 * ErrorMessage(new Date(), errorMessageDescription);
	 * 
	 * return new ResponseEntity<Object>(errorMessage, new HttpHeaders(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	
	@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest reuest){
		String errorMessageDescription = ex.getLocalizedMessage();
		if(errorMessageDescription == null) errorMessageDescription = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
