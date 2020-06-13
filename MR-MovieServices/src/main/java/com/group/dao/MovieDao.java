package com.group.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.group.model.Movie;

@Service
public class MovieDao {

	Map<String, List<Movie>> allMovie = new HashMap<String, List<Movie>>();

	public List<Movie> getMovieList(final String entity){

		List<Movie> hindiList = Arrays.asList(Movie.getObj("AndaDoon", "ad10",new Date(new GregorianCalendar(2018, 9, 22).getTimeInMillis())),
				Movie.getObj("Dabang", "dbg10",new Date(new GregorianCalendar(2018, 4, 22).getTimeInMillis())),
				Movie.getObj("URI", "uri10",new Date(new GregorianCalendar(2019, 1, 22).getTimeInMillis())),
				Movie.getObj("Dhamal", "dm10", new Date(new GregorianCalendar(2017, 9, 22).getTimeInMillis())));

		List<Movie> engList = Arrays.asList(Movie.getObj("Avengers", "av10",new Date(new GregorianCalendar(2018, 9, 22).getTimeInMillis())),
				Movie.getObj("Thor", "th10",new Date(new GregorianCalendar(2018, 4, 22).getTimeInMillis())),
				Movie.getObj("Escape", "esc10",new Date(new GregorianCalendar(2019, 1, 22).getTimeInMillis())),
				Movie.getObj("HarryPotter", "hp10", new Date(new GregorianCalendar(2017, 9, 22).getTimeInMillis())));


		allMovie.put("hn", hindiList);
		allMovie.put("en", engList);
		if(allMovie.containsKey(entity))
			return allMovie.get(entity);
		else
			return null;
	}


}
