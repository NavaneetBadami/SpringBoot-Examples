package com.group.java8.test.lambda;

import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class person implements Comparable<person>{
//	
//	private String name;
//	private String city;
//	
//	public person(String name, String city) {
//		this.name = name;
//		this.city = city;
//	}
//	
//	@Override
//	public String toString() {
//		return this.name +" - "+ this.city;
//	}
//
//	@Override
//	public int compareTo(person o) {
//		return this.city.compareTo(o.city);
//	}
//}
//
//public class CompratorTest {
//	public static void main(String[] args) {
//			
//		List<person> list = new ArrayList<person>();
//		list.add( new person("Navaneet", "Pune"));
//		list.add( new person("Navaneet", "Bijapur"));
//		list.add( new person("Navaneet", "Bangalore"));
//		list.add( new person("Navaneet", "Panvel"));
//		
//		Collections.sort(list);
//		
//		for (person person : list) {
//			System.out.println(person);
//		}
//	}
//}

class person {
	
	String name;
	String city;
	
	public person(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return this.name +" - "+ this.city;
	}
}

class Movie {
	
	public String title;
	public String director;
	
	public Movie(String title, String director) {
		this.title = title;
		this.director = director;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "title: "+ title +" Dirctor: "+director ;
	}

}

public class CompratorTest {
	public static void main(String[] args) {
			
		List<person> list = new ArrayList<person>();
		list.add( new person("Navaneet", "Pune"));
		list.add( new person("Aavaneet", "Bijapur"));
		list.add( new person("Qavaneet", "Bangalore"));
		list.add( new person("Havaneet", "Panvel"));
		
		// Using return
		Collections.sort(list,(p1,p2)->{  
			return p1.city.compareTo(p2.city);  
		});
		for (person person : list) {
			System.out.println(person);
		}
		
		System.out.println("-----------------------------------------");
		
		// Without return
		Collections.sort(list,(p1,p2)->(p1.name.compareTo(p2.name))); 
		for (person person : list) {
			System.out.println(person);
		}
		
		System.out.println("-----------List of Strings Alphabetically----------------- ");
		
		List<String> citie  =  Arrays.asList("Navnaeet","Test","ragavi","aniti");
		citie.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(citie);
		
		citie.sort(Comparator.naturalOrder());
		System.out.println(citie);
		
		System.out.println(" ------------------- movie -----------------");
		List<Movie> movList =  Arrays.asList(new Movie("URI", "xyz"), new Movie("Krish", "xyz"), new Movie("Dor", "xyz"));
		Collections.sort(movList, (p1, p2) -> p1.title.compareTo(p2.title));
//		Collections.sort(list, (e1,e2) -> e1.name.compareTo(e2.name));
		System.out.println(movList);
		
		System.out.println(" ------------------- movie2 chain -----------------");
		List<Movie> movList2 =  Arrays.asList(new Movie("Arish", "xyz"), new Movie("Arish", "Ayz"), new Movie("Dor", "xyz"));
		Collections.sort(movList2, Comparator.comparing(Movie::getTitle).thenComparing(Movie::getDirector));
		System.out.println(movList2);
		
		
	}
}
