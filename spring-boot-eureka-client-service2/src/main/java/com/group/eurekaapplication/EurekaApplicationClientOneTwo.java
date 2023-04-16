package com.group.eurekaapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaApplicationClientOneTwo {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationClientOneTwo.class, args);
		System.out.println("************** EurekaApplicationClientOneTwo Application Started ********");
	}

}
