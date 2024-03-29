package com.eureka.group.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = "com.eureka.group")
public class EurekaApp {
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "eureka");
		SpringApplication.run(EurekaApp.class, args);
	}
	
}
