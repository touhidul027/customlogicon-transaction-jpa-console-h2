package project.controller;

import java.util.Scanner;

import org.springframework.transaction.support.TransactionSynchronization;

public class MyTxSync implements TransactionSynchronization{

	@Override
	public void suspend() {
		// TODO Auto-generated method stub
		System.out.println("Transaction suspended.");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.println("Transaction resumed.");
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		System.out.println("Transaction flushed.");
	}

	@Override
	public void beforeCommit(boolean readOnly) {
		// TODO Auto-generated method stub
		System.out.println("Give your pin number : ");
		Scanner scan = new Scanner(System.in) ; 
		scan.nextInt() ; 
	}

	@Override
	public void beforeCompletion() {
		// TODO Auto-generated method stub
		System.out.println("Transaction is processing ......");
	}

	@Override
	public void afterCommit() {
		// TODO Auto-generated method stub
		System.out.println("Transaction completed.");
	}

	@Override
	public void afterCompletion(int status) {
		// TODO Auto-generated method stub
		System.out.println("Everything is completed.");
	}

}
