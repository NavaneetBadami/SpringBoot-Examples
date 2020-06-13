package com.example.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found") //404
public class EmployeeNotFoundException extends Exception
{
	 private static final long serialVersionUID = -3332292346834265371L;
	 
	    private String errorMessage;
	    private Integer errorCode;
	    private String reason;
	    
	    
	    public EmployeeNotFoundException(int id) {
	        super("Using super() EmployeeNotFoundException with id="+id);	//whole String
	    }
	    
	    public EmployeeNotFoundException(String message,int id) {
	        super("Using super()"+message+" "+id);	//whole String
	    }

	    public EmployeeNotFoundException(String errorMessage,Integer errorCode, String reason) {
			this.errorMessage = errorMessage;
			this.errorCode = errorCode;
			this.reason = reason;
		}

		@Override							//Own Implementation.
	    public String getMessage() {
	    	return "Using getMessage() EmployeeNotFoundException Exception occurs";
	    }
	    
	    @Override
	    public String getLocalizedMessage() {
	    	return "Using getLocalizedMessage() EmployeeNotFoundException Exception occurs";
	    }
	    
	    @Override
	    public String toString() {
	    	return "Using toString() EmployeeNotFoundException Exception aries";
	    }

		/**
		 * @return the errorMessage
		 */
		public String getErrorMessage() {
			return errorMessage;
		}

		/**
		 * @param errorMessage the errorMessage to set
		 */
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		/**
		 * @return the errorCode
		 */
		public Integer getErrorCode() {
			return errorCode;
		}

		/**
		 * @param errorCode the errorCode to set
		 */
		public void setErrorCode(Integer errorCode) {
			this.errorCode = errorCode;
		}

		/**
		 * @return the reason
		 */
		public String getReason() {
			return reason;
		}

		/**
		 * @param reason the reason to set
		 */
		public void setReason(String reason) {
			this.reason = reason;
		}
	    
	    
}
