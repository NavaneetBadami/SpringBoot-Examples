package com.group.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.bean.CombinedService;
import com.group.bean.EmployeeService;
import com.group.bean.StudentService;
import com.group.impl.ServiceImpl;
import com.group.impl.TestImpl;

@RestController
public class SpringBootController {
	
	@Autowired
	private StudentService stdServ; 
	@Autowired
	private EmployeeService empServ;
	@Autowired
	private Mapper mapper;
	@Autowired
	private TestImpl testImpl;
	@Autowired
	private CombinedService combinedService;
	
	@RequestMapping(value ="/msg")
	public String getWelcomeMsg() {
		System.out.println("****************getWelcomemsg()");
		return "<html><h1>HELLO WELCOME TO SPRING BOOT</h1></html>";
	}
	
	@RequestMapping(value ="/json")
	public ResponseEntity<EmployeeService> getWelcomeJson() {
		System.out.println("****************getWelcomeJson()");
		EmployeeService service = new EmployeeService();
		service.setEmpId("101");
		service.setEmpName("dsdsd");
		service.setLocation(null);
		service.setEmpExp(null);
		return new ResponseEntity<EmployeeService>(service,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/id/{id}")
	public String getWelcomeError(@PathVariable String id) throws Exception {
		ServiceImpl impl = new ServiceImpl();
		String idc = impl.getCustId(id);
		return "HELLO WELCOME TO SPRING BOOT_" + idc;
	}
	
	@RequestMapping(value ="/std")
	public String getStudSer() throws Exception {
		return stdServ.getId() +" "+stdServ.getName();
	}
	
	@RequestMapping(value ="/emp")
	public EmployeeService getEmpSer() throws Exception {
		EmployeeService employeeService = new EmployeeService();
		mapper.map(empServ,employeeService);
		return employeeService;
	}
	
	@RequestMapping(value ="/ctry")
	public String getTestInfo() throws Exception {
		System.out.println("********************************");
		return testImpl.getCountryInfo() +"  ||  "+testImpl.getRefData() +"  ||  "+ testImpl.getEmployeeInfo() + "  ||  " + testImpl.getStudentInfo() + "===>" + combinedService.getCombinedServiceData();
	}
}
