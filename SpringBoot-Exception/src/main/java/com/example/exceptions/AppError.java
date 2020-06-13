package com.example.exceptions;

public enum AppError {
	
	EMP_NOT_FOUND (001);
	
	
	private Integer code;
    AppError(Integer error){	
    	this.code = error;
    }
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	
    
}
