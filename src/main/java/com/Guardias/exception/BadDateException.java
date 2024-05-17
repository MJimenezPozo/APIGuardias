package com.Guardias.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadDateException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BadDateException(String message) {
		
		super(message);
		
	}

}
