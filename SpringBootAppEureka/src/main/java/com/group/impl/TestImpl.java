package com.group.impl;

import com.group.bean.EmployeeService;
import com.group.bean.StudentService;

public class TestImpl {

	private String entityId;
	private String country;
	private ServiceImpl serviceImpl;
	private EmployeeService employeeService;
	private StudentService studentService; 
	
	public void init() {
       System.out.println(" ======  > Bean has been initilized !!!");
    }
	
	public void destroy() {
		
		this.entityId = "Cleared";
		this.country = "cleared";
	}
	
	public String getCountryInfo() {

		return entityId + country;
	}
	
	public String getRefData() {
		
		return  " Refernce CustData: " + serviceImpl.getCustDetaild();
	}
	
	public String getEmployeeInfo() {
		
		return employeeService.toString();
	}
	
	public String getStudentInfo() {
		
		return studentService.toString();
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public ServiceImpl getServiceImpl() {
		return serviceImpl;
	}
	public void setServiceImpl(ServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



}
