package com.group.eurekaapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class EurekaApplicationClientOne {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationClientOne.class, args);
		System.out.println("************** EurekaApplicationClientOne Application Started ********");
	}

}
