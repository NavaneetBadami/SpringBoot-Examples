package com.group.jpa.jpaExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.jpa.jpaExample.model.Users;
import com.group.jpa.jpaExample.repository.UserJpaRespository;


@RestController
@RequestMapping("/users")
public class Controller {
	
	@Autowired
	UserJpaRespository jpaRespository;
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return jpaRespository.findAll();
	}
	
	@GetMapping("/name/{name}")
	public List<Users> getByName(@PathVariable String name){
		return jpaRespository.findAllByName(name);
	}
	
	@GetMapping("/sal/{sal}")
	public List<Users> getAllSal(@PathVariable String sal){
		return jpaRespository.findAllGreatherThan(Integer.parseInt(sal));
	}
	
	
}
