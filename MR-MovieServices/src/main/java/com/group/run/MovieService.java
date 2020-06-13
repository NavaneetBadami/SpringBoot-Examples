package com.group.run;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages="com.group")
public class MovieService extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MovieService.class, args);
	}
}
