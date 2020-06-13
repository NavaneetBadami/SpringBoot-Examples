package com.group.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group.dao.MovieDao;

@Configuration
public class Config {

	@Bean
	public MovieDao getMovieDao() {
		return new MovieDao();
	}
	
}
