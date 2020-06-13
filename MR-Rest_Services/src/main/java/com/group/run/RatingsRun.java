package com.group.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.group")
public class RatingsRun {

	public static void main(String[] args) {
		SpringApplication.run(RatingsRun.class, args);
	}
	
}
