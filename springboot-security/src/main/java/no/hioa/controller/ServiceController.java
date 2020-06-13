package no.hioa.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Usman on 08.05.2017.
 */

@RestController
@RequestMapping("/rest")
public class ServiceController {

	@ResponseBody
	@RequestMapping(value ="/hello", method = RequestMethod.GET)
	public String getHello() {
		return "hello Security successful";
	}
	
	@GetMapping
	public String sayHello() {
		return "hello Security successful say";
	}
	
}
