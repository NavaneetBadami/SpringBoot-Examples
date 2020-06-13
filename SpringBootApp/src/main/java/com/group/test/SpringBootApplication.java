package com.group.test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan(basePackages = "com.group")
public class SpringBootApplication {
	
	public static void main(String[] args) {
		 // Tell Boot to look for employee.yml, default looks for application.yml
	    System.setProperty("spring.config.name", "employee");
		SpringApplication.run(SpringBootApplication.class, args);
		
	}
}
