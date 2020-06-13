package com.group.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:studProp.properties")
public class StudentService {
	
	@Value("${std.name}")
	private String name;
	@Value ("${std.id}")
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	
	@Override
	public String toString() {

		String desc = "[" + name + " " + id +"]";
		return desc;
	}
	
}
