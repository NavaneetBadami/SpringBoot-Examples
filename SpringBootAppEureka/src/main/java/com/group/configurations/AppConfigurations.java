package com.group.configurations;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.bean.EmployeeService;
import com.group.bean.StudentService;
import com.group.impl.ServiceImpl;
import com.group.impl.TestImpl;

@Component
public class AppConfigurations {
	
		/* Replacement of XML bean, same beans defined in Class level format*/
	
	@Bean
	@Scope("prototype")
	public org.dozer.Mapper mapper() {
		DozerBeanMapper beanMapper = new DozerBeanMapper();
		List<String> mappingFileUrls = new ArrayList<String>();
		mappingFileUrls.add("mapping/dozer-bean-mappings.xml");
		beanMapper.setMappingFiles(mappingFileUrls);
	    return beanMapper;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}
	
	@Bean(name = "servImpl1")
	public ServiceImpl serviceImpl() {
		ServiceImpl impl = new ServiceImpl();
		impl.setId("43908205");
		impl.setName("TestUser1");
		return impl;
	}
	
	@Bean(name = "servImpl2")
	public ServiceImpl serviceImpl2() {
		ServiceImpl impl = new ServiceImpl();
		impl.setId("43908206");
		impl.setName("TestUser2");
		return impl;
	}
	
	@Bean(initMethod ="init")
//	@Bean(destroyMethod = "destroy")
	public TestImpl testImpl(@Qualifier("servImpl2")ServiceImpl serviceImpl, @Autowired EmployeeService employeeService, StudentService studentService) {
		TestImpl impl = new TestImpl();
		impl.setCountry("IN");
		impl.setEntityId("GBEU");
		impl.setServiceImpl(serviceImpl); // reference type ref-Injection 
		impl.setEmployeeService(employeeService);	//Autowired bean
		impl.setStudentService(studentService);		//without Autowired but bean is available in container as this class annotated as component 
		return impl;
	}
	
}
