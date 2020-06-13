package com.example.controller;
import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	
    @RequestMapping(value="/emp/{id}")
    public String getEmployee(@PathVariable("id") int id) throws Exception{
        //deliberately throwing different types of exception
        if(id==1){
//            throw new EmployeeNotFoundException(id);
//            throw new EmployeeNotFoundException("EmployeeNotFoundException:",id);
        	throw new EmployeeNotFoundException("Emply Exception", 609, "Not satidfied condition");
        		
        }
        else if(id==2) {
            throw new SQLException("SQLException, id="+id);
            								//database_error.jsp
        }
        else if(id==3) {
            throw new IOException("IOException, id="+id);
        }
        else if(id==10) {
      
            return "Working as expected";
        }
        
        else if(id == 11 ){
        	
        }
        else {
            throw new Exception("Generic Exception, id="+id);
        }
    }
    
     
    /*@ExceptionHandler(EmployeeNotFoundException.class)		//Custom exception.
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception exception)//PRCO , we can also use EmployeeNotFoundException exception 
    {
        logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+exception);
        logger.error("Exception Raised="+exception.getLocalizedMessage());
        logger.error("Exception Raised="+exception.getCause());
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURL());
         
        modelAndView.setViewName("error");
        return modelAndView;
    }   */
    											//sending JSON response if id==1
//    @ExceptionHandler(EmployeeNotFoundException.class)
//    public ResponseEntity<?> handleEmployeeNotFoundException(HttpServletRequest request,Exception ex){    
//    	
//    	ExceptionJSONInfo JSONresponse = new ExceptionJSONInfo();
//    	if(ex instanceof EmployeeNotFoundException) {
//    		
//    		EmployeeNotFoundException ene = (EmployeeNotFoundException) ex;  
//    		
//            JSONresponse.setUrl(request.getRequestURL().toString());	//setting
//            JSONresponse.setMessage(ene.getErrorMessage());
//            JSONresponse.setReason(ene.getReason());
//            JSONresponse.setErrorCode(ene.getErrorCode());
//    	}
//        return new ResponseEntity<ExceptionJSONInfo>(JSONresponse,HttpStatus.valueOf(500));
//    }
    
    
}
/*-------Notes Of Exception----- 
 1.Different way to handle the exception
 	a.Using Controller based ExceptionHandler (Within the controller.)
 	b.Global based exceptionHandler (within controllerAdvice)
 	c.Exception Resolver(within controllerAdvice or XMl) or Define @ExceptionHandler(Exception.class)
 	
 -	whenever exception occurs in @Controller or any part of MVC the spring will look for particular handler who would handle it properly,
  	handler means using @ExceptionHandler(Exp.Class)annotation
 -  when exception occurs then spring look for handlers which taking raised exception class. I.e if exception is SqlException the spring look
  	for handler which taking SqlException.class @ExceptionHandler(SqlException.class)
 -	If raised handler not found then it look for super most class exception which is Exception.class i.e@ExceptionHandler(Exception.class.class)within @Controller only.
 	
 - 	Even If super most class Exception.class handler not found within the @Controller then spring search it for in Global
 	i.e @ControllerAdvice class, then again it follow the same procedure to find matching Handler
 	- looking for SqlException.class handler finds ok,if not then it looks for Exception.class handler in @ControllerAdvice.
 	-if both Handlers not found in @ControllerAvice also then spring throws the exception.
 		
 	
 	 -Priority of Searching @HandlerException(_) by Spring
 		1.Within @Controller with specific Exception name or Super Class name
 		2.Within @ControllerAdvice specific Exception name or Super Class name
 		3.Finally throws exception.
 	
 	- If we define @HandlerException(SQLException.class) in both @Controller and @ControllerAdice then within @Controller will be executed. 
 	- If we define @HandlerException(Exception.class)in @Controller this will be executed at any cost whether you did define in @ControllerAdvice for any exception.
 	
 	
 	- For any @HanderException(-) the method return type is either String or ModelAndView or Void only.
 	- If we use String then return type must be response .jsp file name. 
 		eg: return "error" i.e error.jsp
 		
 	- If we use ModelAndView then we can add some information like addObject(-,-) using MOdelAndView object and we can forward it to response .jsp file.
		eg: model.addObject("exception",exception);
			model.addObject("message","Sorry went wrong try again..");
			return model;
	
	- If we use void as a return type then this is 404 exception, so that time we can redirect it to common static page by
	  using @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured"), if SQlEception occurs then we don't want to
	  display any technical errors then write  @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured") above the
	  @HandlerException(SqlException.class) and return type must be void and reason="" is compulsory.
*/





