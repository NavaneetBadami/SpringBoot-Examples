package com.group.bean;

import java.util.List;

import com.group.model.Movie;

public class MovieResponse {

	private List<Movie>  movies;

	/**
	 * @return the movies
	 */
	public List<Movie> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	
}
