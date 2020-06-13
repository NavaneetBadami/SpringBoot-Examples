package com.group.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.group.model.Ratings;

@Service
public class RatingsDao {

	public Ratings getRatings(final String movieId) {
		
		Map<String, Ratings> map = new HashMap<String, Ratings>();
		map.put("dbg10", Ratings.getObj("dbg10", 3.3, "es"));
		map.put("uri10", Ratings.getObj("uri10", 4.5, "es"));
		map.put("dm10", Ratings.getObj("dm10", 4.0, "es"));
		
		if(map.containsKey(movieId))
			return map.get(movieId);
		else
			return null;
	}
	
	
}
