package com.group.aws.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "com.group")
public class Run extends SpringBootServletInitializer {	
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "employee");
		SpringApplication.run(Run.class, args);
	}
}
