package com.group.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomErrorType extends Exception{

	private static final long serialVersionUID = 1L;

	public CustomErrorType(int status, String erroMessage) {			
	
		super(erroMessage + " " + status );
	}
	
	public CustomErrorType() {			
		super();
	}
	
}
