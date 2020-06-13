package com.group.model;

public class Ratings {
	
	private String movieId;
	private double ratings;
	private String zone;
	
	public Ratings(String movieId, double ratings, String zone) {
		this.movieId = movieId;
		this.ratings = ratings;
		this.zone = zone;
	}
	
	public static Ratings getObj(String movieId, double ratings, String zone) {
		return new Ratings(movieId, ratings, zone);
	}
	
	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the ratings
	 */
	public double getRatings() {
		return ratings;
	}
	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
}
