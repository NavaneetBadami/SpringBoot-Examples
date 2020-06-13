package com.group.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.group.bean.MovieResponse;
import com.group.bean.RatingsResponse;
import com.group.dao.RatingsDao;
import com.group.model.CustomeHeader;
import com.group.model.Movie;
import com.group.model.Ratings;

@RestController
public class MovieCatlogController {

	@Autowired
	private RatingsDao ratingsDao;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/catlog/{lang}")
	public MovieResponse getRatings(@PathVariable final String lang) {
		
//		List<Movie> list =	restTemplate.getForObject("http://localhost:8081/movieservices/movies/"+lang, List.class);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-TP-DeviceID", "1234567890");
		CustomeHeader customeHeader = new CustomeHeader();
		customeHeader.setCc("GB");
		customeHeader.setGmcode("hbeu");
		
		String url ="http://localhost:8081/movieservices/movies/"+lang;
		HttpEntity entity = new HttpEntity(headers);
		
		ResponseEntity<List> list =	restTemplate.exchange(url, HttpMethod.GET, entity, List.class);
		MovieResponse movieResponse = new MovieResponse();
		System.out.println(list.getStatusCodeValue());
		movieResponse.setMovies((List<Movie>) list.getBody().stream().collect(Collectors.toList()));
	
		return movieResponse;
	}
}
