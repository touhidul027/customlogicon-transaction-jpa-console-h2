package project.service;

import java.util.List;

import project.model.Account;

public interface AccountService {
	public void insert(Account account);
    public void update(Account account);
    public void update(List<Account> accounts);
    public void delete(long accountId);
    public Account find(long accountId);
    public List<Account> find(List<Long> accountIds);
    public List<Account> find(String ownerName);
    public List<Account> find(boolean locked);
	
	public void transferMoney(long sourceAccountId, long targetAccountId,
			double amount);
	public void depositMoney(long accountId, double amount) throws Exception;
}
