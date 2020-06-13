package com.group.impl;

import java.util.Random;
import com.group.advice.CustomErrorType;

public class ServiceImpl {
	
	private String name;
	private String id;

	public String getCustId(String name) throws CustomErrorType {
		if( name.equalsIgnoreCase("test")) {
			throw new CustomErrorType(404,"Name cannot be as Test");
		}
		String custId = name + new Random().nextInt(); 
				
		return custId;
	}
	
	public String getCustDetaild() {
		
		return name + " " + id;
	}
	
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

}
