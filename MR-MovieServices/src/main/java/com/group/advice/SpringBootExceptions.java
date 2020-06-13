package com.group.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages="com.group")
public class SpringBootExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex){
		HttpStatus status = getStatus(request);
		logger.info("Exception Occured:: URL="+request.getRequestURL());
//		return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
		System.out.println(ex.getMessage());
		return new ResponseEntity<>(status);
	}
	
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
	
}
