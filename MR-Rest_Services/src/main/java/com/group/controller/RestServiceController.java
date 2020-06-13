package com.group.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.group.bean.RatingsResponse;
import com.group.dao.RatingsDao;
import com.group.model.Movie;
import com.group.model.Ratings;

@RestController
public class RestServiceController {

	@Autowired
	private RatingsDao ratingsDao;
	
	private RestTemplate template = new RestTemplate();
	
	@RequestMapping("/rest1/{entity}")
	public Movie[] geRest1(@PathVariable String entity) throws URISyntaxException {
		
		final String url = "http://restservices-env.eqwj5ewajx.us-east-2.elasticbeanstalk.com/movies/"+entity;
		URI uri = new URI(url);
		Movie[]reult = 	template.getForObject(uri, Movie[].class);
		System.out.println(reult);
		return reult;	
	}
	
	@RequestMapping("/rest2/{entity}")
	public Movie[] geRest2(@PathVariable String entity) throws URISyntaxException {
		
		final String url = "http://restservices-env.eqwj5ewajx.us-east-2.elasticbeanstalk.com/movies/"+entity;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("cc", "fr");
		
		HttpEntity<Movie[]> reqEntity = new HttpEntity<Movie[]>(headers);
		ResponseEntity<Movie[]>	resEntity = template.exchange(url, HttpMethod.GET, reqEntity, Movie[].class);
		
		System.out.println(resEntity.getStatusCode());
		
		return resEntity.getBody();	
	}
	
	
}
