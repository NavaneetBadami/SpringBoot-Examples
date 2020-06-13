package com.group.java8.test.lambda;

@FunctionalInterface
interface Addable{  
    int add(int a,int b);  
}  

public class TwoParam {
	
	// With Lambda Expresion
	 public static void main(String[] args) {  
         
	        // body  
	        Addable ad1=(a,b)-> {
	        	return a+b; 
	        };
	        System.out.println(ad1.add(10,20));  
	        
	        // Without body  
	        Addable ad2=(a,b)->(a+b);
	        System.out.println(ad2.add(10,20));  
	          
	        // Multiple parameters with data type in lambda expression  
	        Addable ad3=(int a,int b)->(a+b);  
	        System.out.println(ad3.add(100,200));  
	    }  
}
