package com.group.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "my")
@Validated
public class EmployeeService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull @NotEmpty 
	private String empId;
	private String empName;
	private List<String> location = new ArrayList<String>();
	@Valid
	private List<EmpExperience> empExp = new ArrayList<EmpExperience>();
	
	public List<EmpExperience> getEmpExp() {
		return empExp;
	}
	public void setEmpExp(List<EmpExperience> empExp) {
		this.empExp = empExp;
	}
	public List<String> getLocation() {
		return location;
	}
	public void setLocation(List<String> location) {
		this.location = location;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	} 
	
	@Override
	public String toString() {
		String desc = "[" + empId + " " +empName + " - " + location.toString()+" "+empExp.toString()+"]";
		return desc;
	}
}
