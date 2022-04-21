package com.bank.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.Entity.Account;

@Service
public interface AccountService {
	public void saveAccount(Account a);
	public List<Account> fetchAccount();
	public boolean updateAccount(Account a, long pid);
	public Account deleteAccount(long pid);
	public Account fetchAccountById(long id);
}
