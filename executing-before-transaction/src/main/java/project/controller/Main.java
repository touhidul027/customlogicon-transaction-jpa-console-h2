package project.controller;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.model.Account;
import project.service.AccountService;


public class Main {
	
	// just for testing 
	public static void insert() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Config.class);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		
		Account account = new Account();
		account.setOwnerName("Saddam");
		account.setBalance(20000.0);
		account.setAccessTime(new Date());
		account.setLocked(false);
		
		accountService.insert(account);
	}

	public static void depositMoney() throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Config.class);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		
		accountService.depositMoney(3,5000L);
	}
	
	
	public static void transferMoney() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Config.class);
		AccountService accountService = applicationContext.getBean(AccountService.class);
		accountService.transferMoney(4, 3, 5000L);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub				
		 Main.transferMoney();
	}

}
