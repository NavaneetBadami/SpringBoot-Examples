package com.group.aws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAwsController {

	@RequestMapping(value ="/check")
	public String getWelcomeMsg() {
		System.out.println("****************getWelcomemsg()");
		return "<html><h1>HELLO WELCOME TO SPRING BOOT</h1></html>";
	}
	
}
