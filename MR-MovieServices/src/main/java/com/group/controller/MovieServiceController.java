package com.group.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.bean.MovieResponse;
import com.group.dao.MovieDao;
import com.group.model.Movie;

import java.util.logging.Logger;

@RestController
public class MovieServiceController {

	@Autowired
	private MovieDao movieDao;

	@RequestMapping("/movies/{entity}")
	public List<Movie> getMovies(@RequestHeader Map<Object, Object> headers	,@PathVariable String entity) {
		
		headers.forEach((key, value) -> {
			System.out.printf(" = == >Headres %s = %s \n", key, value );
		});
		
		MovieResponse movieResponse = new MovieResponse();
		List<Movie>	movies = movieDao.getMovieList(entity);
		movieResponse.setMovies(movies);
		return movies;
	}
}
