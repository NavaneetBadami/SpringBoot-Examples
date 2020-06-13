package com.group.java8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class employee {
	
	String name;
	double height;
	
	public employee(String name, double height) {
		this.name = name;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return this.name +" - "+ this.height;
	}
}

public class StreamTest {
	
	public static void main(String[] args) {
		List<employee> list = new ArrayList<employee>();
		list.add( new employee("Navaneet", 5.7));
		list.add( new employee("Aavaneet", 6.0));
		list.add( new employee("Qavaneet", 5.8));
		list.add( new employee("Havaneet", 5.1));
		
		System.out.println("--------------just print--------------------");
		list.forEach(System.out::println);
//		list.forEach((v) ->System.out.println(v));
		
		System.out.println("--------------filter--------------------");
		Stream<employee> empData = list.stream().filter(e -> e.height >= 5.8); 
		empData.forEach((val) -> System.out.println(val));
	//	empData.forEach((val) -> System.out.println(val));  //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		
		System.out.println("--------------allMatch--------------------");
		System.out.println(list.stream().allMatch(e -> e.name.endsWith("ett")));
		
		System.out.println("---------------findFirst-------------------");
		Optional<employee> empD = list.stream().findFirst();
		System.out.println(empD);
		
		System.out.println("--------------findAny--------------------");
		Optional<employee> empA = list.stream().findAny();
		System.out.println(empA);
		
		System.out.println("----------------limit------------------");
		Stream<employee> empL = list.stream().limit(2);
		empL.forEach((e) -> System.out.println(e));
	//	empL.forEach((e) -> System.out.println(e));
		
		System.out.println("----------------sorted userdefine obj------------------");
		Stream<employee> empS = list.stream().sorted((e1,e2) -> e1.name.compareTo(e2.name)).limit(3);
		empS.forEach((e) -> System.out.println(e));
		
		System.out.println("----------------sorted integer Arrays------------------");
		List<Integer> intList = Arrays.asList(-9, -18, 0, 25, 4);
//	    intList.stream().sorted().forEach(System.out::println); 
		intList.stream().sorted().forEach((i) -> System.out.println(i)); 
		
		System.out.println("---------------- reverse integer Arrays------------------");
		intList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); 
		
		System.out.println("----------------sorted String Arrays------------------");
		List<String> strList = Arrays.asList("Geeks", "for", "NeeksQuiz", "QeeksforGeeks", "GFG"); 
//		strList.stream().sorted().forEach((s) -> System.out.println(s));
		strList.stream().sorted().forEach(System.out::println);
		
		System.out.println("----------------reverse String Arrays------------------");
		strList.stream().sorted(Comparator.reverseOrder()).forEach((s) -> System.out.println(s));
		
		System.out.println("----------------map------------------");
		List<Double> epd =list.stream().filter(p -> p.height > 5.8).map( p -> p.height).collect(Collectors.toList());
		System.out.println(epd); // using map Fetching data as a List 
		
		System.out.println("----------------collect------------------");
		List<employee> ep =list.stream().filter(p -> p.height >= 5.8).collect(Collectors.toList()); // collecting values in LIST form
		System.out.println(ep);  //  Fetching data as a List
		
		System.out.println("----------------forEOrderd------------------");
		list.stream().forEachOrdered(e -> System.out.println(e));
		
		System.out.println("----------------Sum------------------");
		List<Integer> inList = Arrays.asList(3,6,5,4,4,4);
		int result = inList.stream().filter(i -> i >= 4).mapToInt(i -> i).sum();
		System.out.println(result);
		
	}
}
