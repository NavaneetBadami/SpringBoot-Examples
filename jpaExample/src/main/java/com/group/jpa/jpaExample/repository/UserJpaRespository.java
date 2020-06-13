package com.group.jpa.jpaExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.group.jpa.jpaExample.model.Users;

@Component
public interface UserJpaRespository extends JpaRepository<Users, Integer> {

	public List<Users> findAllByName(String name);
	
	@Query(value = "Select * from users where salary >= 3000", nativeQuery = true	)
	public List<Users> findAllGreatherThan(int sal);
}
