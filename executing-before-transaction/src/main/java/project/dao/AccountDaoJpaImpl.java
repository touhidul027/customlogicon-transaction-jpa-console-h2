package project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import project.controller.MyTxSync;
import project.model.Account;


public class AccountDaoJpaImpl implements AccountDao{

	@PersistenceContext
	private EntityManager entityManager ; 
	
	public void insert(Account account) {
		entityManager.persist(account);
	}

	public void update(Account account) {
		entityManager.merge(account) ; 
		entityManager.flush();
	}

	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long accountId) {
		// TODO Auto-generated method stub
		
	}

	public Account find(long accountId) {
		return entityManager.find(Account.class, accountId) ; 
	}

	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}
}
