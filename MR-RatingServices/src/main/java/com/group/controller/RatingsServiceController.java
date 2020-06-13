package com.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group.bean.RatingsResponse;
import com.group.dao.RatingsDao;
import com.group.model.Ratings;

@RestController
public class RatingsServiceController {

	@Autowired
	private RatingsDao ratingsDao;
	
	@RequestMapping("/ratings/{movieId}")
	public RatingsResponse getRatings(@PathVariable final String movieId) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		Ratings ratings = ratingsDao.getRatings(movieId);
		ratingsResponse.setRatings(ratings);
		return ratingsResponse;
	}
	
	@RequestMapping(value = "/ratings/update", method = RequestMethod.POST)
	public RatingsResponse updateRatings(@RequestBody final Ratings upRatings) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		Ratings ratings = ratingsDao.getRatings(upRatings.getMovieId());
		System.out.println(" ====== > Updating values: "+ upRatings.getRatings());
		ratings.setRatings(upRatings.getRatings());
		ratingsResponse.setRatings(ratings);
		return ratingsResponse;
	}
	
}
