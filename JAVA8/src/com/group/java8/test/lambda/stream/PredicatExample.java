package com.group.java8.test.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
	
	private String empName;
	private String empId;
	private int age;
	private double salary;
	
	public Employee(String empName, String empId, int age, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}
	
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		
		return this.empId +" "+this.empName+" "+this.age+" "+this.salary;
	}
	
}

// Define common predicate lambda expression
class EmployeePredicate {
	
	static Predicate<Employee> isAdult() {
		return p -> p.getAge() > 18;
	}
	
	static Predicate<Employee> isSalaryMoreThan(double sal) {
		return p -> p.getSalary() > sal;
	}
	
}


public class PredicatExample {
	
	static int age = 18;
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Navaneet","001",21,12000));
		employees.add(new Employee("Rohit","002",27,10000));
		employees.add(new Employee("Kiran","003",28,14000));
		employees.add(new Employee("Ravi","004",25,7000));
		
//		System.out.println(" Are all Employes Adult ? : "+ employees.stream().allMatch(p -> p.getAge() > 18));
		System.out.println(" Are all Employes Adult ? : "+ employees.stream().allMatch(EmployeePredicate.isAdult()));
		
//		System.out.println(" Are all Employes Adult ? : "+ employees.stream().allMatch(p -> p.getSalary() >= 7000));
		System.out.println(" Are all Employes Adult ? : "+ employees.stream().allMatch(EmployeePredicate.isSalaryMoreThan(6000)));
		
//		System.out.println(" Are all Employes Adult ? : "+ employees.stream().anyMatch(p -> p.getSalary() >= 10000));
		System.out.println(" Are all Employes Adult ? : "+ employees.stream().anyMatch(EmployeePredicate.isSalaryMoreThan(10000)));
		
//		employees.stream().filter(e -> e.getAge() > 18).forEach(e -> System.out.println(e.getEmpName()));
		employees.stream().filter(EmployeePredicate.isAdult()).forEach(e -> System.out.print(e.getEmpName()+","));
//		employees.stream().filter(EmployeePredicate.isAdult()).collect(Collectors.toList()).forEach(e -> System.out.print(e.getEmpName()+","));
		
		 String G7Countries = employees.stream().map(x -> x.getEmpName().toUpperCase()).collect(Collectors.joining(", "));
		 System.out.println(G7Countries);
		 
		 System.out.println("\n***************** MAP TO LIST*********************");
		 Map<String, List<Object>>  map = new HashMap<String, List<Object>>();
		 map.put("006", Arrays.asList("Rohan","006",27,3000.00)) ;
		 map.put("007", Arrays.asList("Ramesh","007",29,4000.00)) ;
		 map.put("008", Arrays.asList("Laki","007",24,8000.00)) ;
		 map.entrySet().stream().map(m -> new Employee((String)m.getValue().get(0),(String)m.getValue().get(1),(Integer)m.getValue().get(2),(Double)m.getValue().get(3))).collect(Collectors.toList()).forEach(System.out::println);
		 
		 System.out.println("***************** SORT ***************8");
	//	 employees.stream().sorted((e1,e2) -> e1.getEmpName().compareTo(e2.getEmpName())).forEach(System.out::println);
		 employees.stream().sorted(Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getEmpId)).forEach(System.out::println);
		
		
	}
}










