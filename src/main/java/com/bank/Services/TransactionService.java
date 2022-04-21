package com.bank.Services;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
	public double withdraw(long accountId, double balance);
	public double deposit(long accountId, double balance);
	public double getBalance(long accountId);
	public boolean fundTransfer(long fromAccount, long toAccount, double amont);
	public boolean validateAccount(long id,String password);
}
