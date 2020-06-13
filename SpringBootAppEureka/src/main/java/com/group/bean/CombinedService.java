package com.group.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CombinedService {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private StudentService studentService;
	
	
	public String getCombinedServiceData() {
		
		return  employeeService.toString() +" |||| " + studentService.toString();
		
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
