package com.group.java8.test.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("Test-1");
		list.add("Test-2");
		list.add("Test-3");
		list.add("Test-4");
		
		//Traditional way
		for (String data : list) {
			System.out.println(data);
		}
		
		// Lambda exp
		list.forEach((data)-> System.out.println(data));
		
	}
}
