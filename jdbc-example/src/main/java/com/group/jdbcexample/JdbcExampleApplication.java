package com.group.jdbcexample;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.group.jdbcexample.exception.InsufficientAccountBalance;
import com.group.jdbcexample.model.Account;
import com.group.jdbcexample.model.Customer;
import com.group.jdbcexample.service.BankService;
import com.group.jdbcexample.service.CustomerService;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true)
public class JdbcExampleApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Opertaion ");
		int choice = scanner.nextInt();
		if(choice == 1) {
			ApplicationContext applicationContext =	SpringApplication.run(JdbcExampleApplication.class, args);
			CustomerService customerService = (CustomerService)applicationContext.getBean(CustomerService.class);

			customerService.insertCustomer(new Customer("001", "TestUser"));
		} else if(choice == 2){

			ApplicationContext applicationContext =	SpringApplication.run(JdbcExampleApplication.class, args);
			BankService bankService = (BankService)applicationContext.getBean(BankService.class);

			Account fromAccount = new Account();
			fromAccount.setAccountNumber("1234567");

			Account toAccount = new Account();
			toAccount.setAccountNumber("1234568");

			try {
				bankService.transferFund(fromAccount, toAccount, 1000.00);
			} catch (InsufficientAccountBalance e) {
				System.out.println("Exception: "+ e.getMessage());
			}	
		}
	}
}
