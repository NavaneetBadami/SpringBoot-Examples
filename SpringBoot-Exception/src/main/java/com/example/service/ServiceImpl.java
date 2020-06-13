package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

	@Autowired
	private DaoImpl dao;
	
	public Employee getEmps(Integer id) throws EmployeeNotFoundException {
		
		return this.dao.getDbData(id);
	}
	
}
