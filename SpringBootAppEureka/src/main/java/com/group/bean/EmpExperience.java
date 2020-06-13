package com.group.bean;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;


public class EmpExperience implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String employer;
	private String role;
	private double ctc;
	private double months;
	private List<String> projects;
	private boolean empStatus;
	
	public List<String> getProjects() {
		return projects;
	}
	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getCtc() {
		return ctc;
	}
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
	public double getMonths() {
		return months;
	}
	public void setMonths(double months) {
		this.months = months;
	}
	public boolean isEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}
	@Override
	public String toString() {
		return "["+ employer +" "+ role + " "+ ctc +" "+ months +" "+projects+" "+empStatus+"]";
	}

}
