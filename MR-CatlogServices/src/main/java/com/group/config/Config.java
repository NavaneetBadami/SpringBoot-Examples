package com.group.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group.dao.RatingsDao;

@Configuration
public class Config {

	@Bean
	public RatingsDao getRatingsDao() {
		return new RatingsDao();
	}
	
}
