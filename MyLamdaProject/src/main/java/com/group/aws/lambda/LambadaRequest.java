package com.group.aws.lambda;

public class LambadaRequest {
	
	String name;
	String city;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		
		return "Name: "+ name +" - "+city;
	}
	
}	

