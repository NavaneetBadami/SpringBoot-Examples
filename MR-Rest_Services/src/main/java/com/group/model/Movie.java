package com.group.model;

import java.util.Date;

public class Movie {

	private String movieName;
	private String movieId;
	private Date movieReleaseDate;
	
	public Movie() {
		
	}
	private Movie(String movieName, String movieId, Date movieReleaseDate) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieReleaseDate = movieReleaseDate;
	}
	
	// instance factory method
	public static Movie getObj(String movieName, String movieId, Date movieReleaseDate) {
		 return new Movie(movieName, movieId, movieReleaseDate);
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
		
}
