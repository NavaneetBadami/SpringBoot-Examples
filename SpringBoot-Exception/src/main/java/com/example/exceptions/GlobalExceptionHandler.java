package com.example.exceptions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

 
@RestControllerAdvice
public class GlobalExceptionHandler 
{
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
	 @ExceptionHandler(EmployeeNotFoundException.class)
	    public ResponseEntity<?> handleEmployeeNotFoundException(HttpServletRequest request,Exception ex){    
	    	
	    	ExceptionJSONInfo JSONresponse = new ExceptionJSONInfo();
	    	if(ex instanceof EmployeeNotFoundException) {
	    		
	    		EmployeeNotFoundException ene = (EmployeeNotFoundException) ex;  		
	            JSONresponse.setUrl(request.getRequestURL().toString());	//setting
	            JSONresponse.setMessage(ene.getErrorMessage());
	            JSONresponse.setReason(ene.getReason());
	            JSONresponse.setErrorCode(ene.getErrorCode());
	    	}
	        return new ResponseEntity<ExceptionJSONInfo>(JSONresponse,HttpStatus.valueOf(500));
	    }
	
	
    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSQLException(HttpServletRequest request, Exception exception )
    {
        logger.info("SQLException Occured:: URL="+request.getRequestURL());
        logger.error("Exception raised: "+ exception);
        
        ModelAndView modelAndView= new ModelAndView("database_error");
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception",exception);
 
        return modelAndView;	//database_error.jsp	Note: if return type is String then we must return jspName i.e return "database_error.jsp, we cannot add any model data so if we want to add any model data the return type should be ModelAndView"
    }
     
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured") //reason field is Mandatory and return must be void type to hit 404.jsp
    @ExceptionHandler(IOException.class)
    public void handleIOException()
    {
        logger.error("IOException handler executed");
        //returning 404 error code
    }
    
//    @ExceptionHandler(EmployeeNotFoundException.class)		//Custom exception.
//    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception exception)//PRCO , we can also use EmployeeNotFoundException exception 
//    {
//        logger.error("Requested URL="+request.getRequestURL());
//        logger.error("Exception Raised="+exception);
//        logger.error("Exception Raised="+exception.getLocalizedMessage());
//        logger.error("Exception Raised="+exception.getCause());
//         
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", exception);
//        modelAndView.addObject("url", request.getRequestURL());
//         
//        modelAndView.setViewName("error");	//view name.
//        return modelAndView;
//    }   
    
    @ExceptionHandler(Exception.class)		//global or common, I.e if particular Exception class handler not found then this will execute for sure.
    public String defaultException(HttpServletRequest request, Exception exception)
    {
        logger.info("SQLException Occured:: URL="+request.getRequestURL());
        logger.error("Exception Raised="+exception);
        return "generic_error";		//jsp page.
    }
    
   
    
}
