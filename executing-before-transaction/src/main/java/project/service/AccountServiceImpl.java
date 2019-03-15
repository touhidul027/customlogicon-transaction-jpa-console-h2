package project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import project.controller.MyTxSync;
import project.dao.AccountDao;
import project.model.Account;

@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

	public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
		// TODO Auto-generated method stub
	     TransactionSynchronizationManager.registerSynchronization(new MyTxSync());
		    Account sourceAccount = accountDao.find(sourceAccountId);
	        Account targetAccount = accountDao.find(targetAccountId);
	        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
	        targetAccount.setBalance(targetAccount.getBalance() + amount);
	        accountDao.update(sourceAccount);
	        accountDao.update(targetAccount);
	}

	@Override
	public void depositMoney(long accountId, double amount) throws Exception {
		// TODO Auto-generated method stub	
	     TransactionSynchronizationManager.registerSynchronization(new MyTxSync());
		Account account = accountDao.find(accountId) ; 
		account.setBalance( account.getBalance()+amount);
		accountDao.update(account);
	}

	@Override
	public void insert(Account account) {
		// TODO Auto-generated method stub
		accountDao.insert(account);
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long accountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account find(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
