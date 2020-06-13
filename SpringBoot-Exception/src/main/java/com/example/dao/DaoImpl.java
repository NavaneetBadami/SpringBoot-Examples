package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl {

	public Employee getDbData(Integer id) throws EmployeeNotFoundException{
		
		if(id == 1) {
		
			return new Employee("Empl", 001);
			
		} else {
			
			throw new EmployeeNotFoundException("BusinessException", AppError.EMP_NOT_FOUND, "INVALID ID");
		}
		
		
		
	}
	
}
