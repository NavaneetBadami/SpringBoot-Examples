package com.group.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.group.bean.ExceptionBean;

@ControllerAdvice(basePackages ="com.group")
public class SpringBootControllerAdvice extends ResponseEntityExceptionHandler {
	
	/*@ExceptionHandler(CustomErrorType.class)
	@ResponseBody
	public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		logger.info("CustomErrorType Occured:: URL="+request.getRequestURL() +" Status: "+ status.value());
		return new ResponseEntity<>(status);
	}*/
	
	@ExceptionHandler(CustomErrorType.class)
	@ResponseBody
	public ExceptionBean handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		logger.info("****CustomErrorType Occured:: URL="+request.getRequestURL() +" Status: "+ status.value());
		
		ExceptionBean bean = new ExceptionBean();
		bean.setUrl(request.getRequestURI());
		bean.setMessage(ex.getMessage());
		bean.setReason(status.getReasonPhrase());
		bean.setStatusCode(status.value());
		return bean;
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<?> handleArithException(HttpServletRequest request, Exception ex){
		HttpStatus status = getStatus(request);
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
//		return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
		return new ResponseEntity<>(status);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex){
		HttpStatus status = getStatus(request);
		logger.info("Exception Occured:: URL="+request.getRequestURL());
//		return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
		System.out.println(ex.getMessage());
		return new ResponseEntity<>(status);
		
	}
	
	@ExceptionHandler(HttpStatusCodeException.class)
	@ResponseBody
	public ResponseEntity<?> notFound(HttpServletRequest request, Exception ex){
		HttpStatus status = getStatus(request);
		logger.info("SQLException Occured:: URL="+request.getRequestURL() +" Status: "+ status.value());
//		return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
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
