package com.group.java8.test.lambda.stream;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.jws.Oneway;

public class StreamExamples {
	public static void main(String[] args) {

		Stream<Integer> streamInt = Stream.of(3,5,7,4,6,8);
		System.out.println("----------------- filer ------------------");
		streamInt.filter(i -> ( i > 4)).filter(i -> (i%2==0)).forEach(System.out::println);

		System.out.println("----------------- filer ------------------");
		Stream<Integer> streamInt2 = Stream.of(3,5,7,4,6,8);
		streamInt2.filter(i -> ( i > 4) && ( i%2 ==0)).forEach(System.out::println);

		//	System.out.println("----------------- filer ------------------");
		//	Stream<Integer> streamInt3 = Stream.of(3,5,7,4,6,8);
		//	streamInt3.filter(i -> i*i).forEach(System.out::println);
		//	streamInt3.map(i -> i*i).forEach(System.out::println);

		System.out.println("----------------- filer 2 ------------------");
		Stream<String> streamStr = Stream.of("Geeks", "fOr", "GEEKSQUIZ", "GeeksforGeeks"); 
		streamStr.filter(s -> Character.isUpperCase(s.charAt(1))).forEach(System.out::println);

		System.out.println("----------------- filer 3 ------------------");
		Stream<String> streamStr2 = Stream.of("Geeks", "foR", "GeEksQuiz", "GeeksforGeeks"); 
		streamStr2.filter(s -> s.endsWith("s")).forEach(System.out::println);

		System.out.println("----------------- filer 4 ------------------");
		Stream<String> streamStr3 = Stream.of("Geeks", "foR", "GeEksQuiz", "GeeksforGeeks"); 
		streamStr3.filter(s -> s.endsWith("s")).collect(Collectors.toSet()).forEach(System.out::println);

		System.out.println("----------------- filer 5 ------------------");
		Stream<String> streamStr4 = Stream.of("Geeks", "foR", "GeEksQuiz", "GeeksforGeeks"); 
		streamStr4.filter(s -> !s.equals("foR")).forEach(System.out::println);

		System.out.println("----------------- filer 6 ------------------");
		Stream<String> streamStr5 = Stream.of("Geeks", "for", "GEEksQuiz", "GEeksforGeeks");         
		System.out.println(streamStr5.filter(s -> Character.isUpperCase(s.charAt(1))).findAny().orElse(null));

		System.out.println("----------------- filer 7 ------------------");
		Stream<String> streamStr6 = Stream.of("Geeks", "for", "GeEksQuiz", "GeeksforGeeks");        
		streamStr6.sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("----------------- filer 8 ------------------");
		Stream<String> streamStr7 = Stream.of("Geeks", "Geeks", "GeEksQuiz", "GeeksforGeeks");        
		streamStr7.distinct().limit(2).forEach(System.out::println);

		/********************************** MAP *************************************/
		System.out.println("----------------- MAP 1 ------------------");
		Stream<String> map1  = Stream.of("Geeks", "for", "GeEksQuiz", "GeeksforGeeks");     
		map1.map(s -> s.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
		//      streamStr8.map(String::toUpperCase).forEach(s -> System.out.println(s));

		System.out.println("----------------- MAP 2 ------------------");
		List<Integer> list = Arrays.asList(3, 6, 9, 12, 15); 
		list.stream().filter(n -> n > 9).map(n -> n*3).forEach(System.out::println);

		boolean bl = list.stream().filter(n -> n > 9).noneMatch(n -> n > 15);
		System.out.println(bl);

		System.out.println("----------------- MAP 3 ------------------");
		List<String> list2 = Arrays.asList("Geeks", "for", "GeEksQuiz", "GeeksforGeeks");    
		list2.stream().map(s -> s.length()).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("----------------- MAP 4 ------------------");
		List<String> list3 = Arrays.asList("1", "2", "3", "4");  
		list3.stream().map(i -> Integer.valueOf(i)).collect(Collectors.toList()).forEach(System.out::println);

		System.out.println("----------------- MAP 5 ------------------");
		List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 4);  
		System.out.println(list4.stream().mapToInt(i -> i).average());  // returns intStream
		System.out.println(list4.stream().filter(i -> i < 2).mapToInt(i -> i).average());  // returns intStream
		System.out.println(list4.stream().flatMap(i -> Stream.of(i)).mapToInt(i -> i).average());
		System.out.println(list4.stream().mapToInt(i -> i).max());
		System.out.println(list4.stream().mapToInt(i -> i).min());
		System.out.println(list4.stream().mapToInt(i -> i).sum());
		System.out.println(list4.stream().mapToInt(i -> i).count());
		System.out.println(list4.stream().mapToInt(i -> i).distinct().count());
		System.out.println(list4.stream().mapToInt(i -> i).findAny().getAsInt());
		list4.stream().mapToInt(i -> i).limit(2).forEach(System.out::print);
		System.out.println("\n"+list4.stream().mapToInt(i -> i).toArray().length);
		System.out.println(list4.stream().mapToInt(i -> i).summaryStatistics());
		System.out.println(list4.stream().mapToLong(i -> i).summaryStatistics());
		System.out.println(list4.stream().mapToDouble(i -> i).summaryStatistics());

		System.out.println("******************FLAT MAP ***************************** " ); 
		List<List<String>> ls1 = Arrays.asList(
				Arrays.asList("Kiran", "Rohit","Ajay"),
				Arrays.asList("Ravi", "Kiran","Ramesh"),
				Arrays.asList("surya", "laxmn","rajesh")) ;  // LIST

		System.out.println(ls1+"\n -------------------");

		ls1.stream().flatMap(Collection::stream).forEach(System.out::println);
		System.out.println("--------- ");
		ls1.stream().map(lst -> lst.get(0).toLowerCase()).forEach(System.out::println);
		System.out.println("=========== ");

		System.out.println("******************FLAT MAP 2***************************** " ); 

		List<Customer> customers = Arrays.asList(new Customer("TEST1", "123","c02"),new Customer("TEST2", "124","c03"));
		List<Order> orders = Arrays.asList(new Order("123"), new Order("126"));

		orders.stream().filter(o -> (o.getOrderId() != null)).map(o -> o.getOrderId()).flatMap(id -> customers.stream().filter(c -> c.getOrderId().equals(id)))
		.collect(Collectors.toList()).forEach(c -> System.out.println(c.getName()));

		System.out.println("************************** FLAT MAP3 ***********");

		List<Trade> trades = Arrays.asList(new Trade("T1", "s01", "c01"), new Trade("T2", "s02", "c02"),new Trade("T3", "s03", "c03"));
		List<Customer> custs = Arrays.asList(new Customer("Nav", "01", "c01"),new Customer("Nav2", "02", "c02"),new Customer("Nav3", "03", "c03"));
		List<Product> products  = Arrays.asList(new Product("s01", "prod1"), new Product("s02", "prod2"),new Product("s03", "prod3"));
	
		
		List<Object> clearanceDatas = trades.stream().parallel().filter(t -> t!= null)
				.flatMap(t -> custs.stream().filter(c -> c.getCcNo().equalsIgnoreCase(t.getCcNo()))
				.flatMap(c ->  products.stream().filter( p -> p.getSecNo().equalsIgnoreCase(t.getSecNO()))
						.map(p -> enrich(t, p, c))))
						.collect(Collectors.toList());
		
		clearanceDatas.forEach(System.out::println);
		

	}

	public static ClearanceData enrich(Trade trade, Product product, Customer customer){

		ClearanceData clearanceData = new ClearanceData();
		clearanceData.setCustomer(customer);
		clearanceData.setProduct(product);
		clearanceData.setTrade(trade);
		return clearanceData;

	}

}


class Customer {

	private String name;
	private String orderId;
	private String ccNo;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", orderId=" + orderId + ", ccNo="
				+ ccNo + "]";
	}

	/**
	 * @return the ccNo
	 */
	public String getCcNo() {
		return ccNo;
	}

	/**
	 * @param ccNo the ccNo to set
	 */
	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public Customer(String name, String orderId, String ccNO){
		this.name =  name;
		this.orderId = orderId;
		this.ccNo = ccNO;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}

class Order {
	private String orderId;

	public Order(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}

class Product {

	private String secNo;
	private String prodName;


	public Product(String secNo, String prodName) {
		super();
		this.secNo = secNo;
		this.prodName = prodName;
	}
	/**
	 * @return the secNo
	 */
	public String getSecNo() {
		return secNo;
	}
	/**
	 * @param secNo the secNo to set
	 */
	public void setSecNo(String secNo) {
		this.secNo = secNo;
	}
	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [secNo=" + secNo + ", prodName=" + prodName + "]";
	}




}

class Trade {

	private String tradeName;
	private String secNO;
	private String ccNo;
	public Trade(String tradeName, String secNO, String ccNo) {
		super();
		this.tradeName = tradeName;
		this.secNO = secNO;
		this.ccNo = ccNo;
	}
	/**
	 * @return the tradeName
	 */
	public String getTradeName() {
		return tradeName;
	}
	/**
	 * @param tradeName the tradeName to set
	 */
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	/**
	 * @return the secNO
	 */
	public String getSecNO() {
		return secNO;
	}
	/**
	 * @param secNO the secNO to set
	 */
	public void setSecNO(String secNO) {
		this.secNO = secNO;
	}
	/**
	 * @return the ccNo
	 */
	public String getCcNo() {
		return ccNo;
	}
	/**
	 * @param ccNo the ccNo to set
	 */
	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trade [tradeName=" + tradeName + ", secNO=" + secNO + ", ccNo="
				+ ccNo + "]";
	}
	
	

}

class ClearanceData {

	private Customer customer;
	private Product product;
	private Trade trade;
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the trade
	 */
	public Trade getTrade() {
		return trade;
	}
	/**
	 * @param trade the trade to set
	 */
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClearanceData [customer=" + customer + ", product=" + product
				+ ", trade=" + trade + "]";
	}
		
	
}

