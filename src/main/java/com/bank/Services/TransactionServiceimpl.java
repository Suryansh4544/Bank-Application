package com.bank.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.Account;
import com.bank.Repositories.AccountRepo;

@Service
public class TransactionServiceimpl implements TransactionService{

	@Autowired
	AccountRepo arepo;
	
	@Override
	public double withdraw(long accountId, double balance) {
		Account acc = arepo.findByaccountid(accountId);
		var currbalance = acc.getBalance();
		if(currbalance>balance) {
			acc.setBalance(currbalance-balance);
			arepo.save(acc);
		}
		return acc.getBalance();  
		
	}

	@Override
	public double deposit(long accountId, double balance) {
		Account acc = arepo.findByaccountid(accountId);
		var currbalance = acc.getBalance();
		acc.setBalance(currbalance+balance);
		arepo.save(acc);
		return acc.getBalance();
	}

	@Override
	public double getBalance(long accountId) {
		return arepo.findByaccountid(accountId).getBalance();
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) {
		Account acc1 = arepo.findByaccountid(fromAccount);
		Account acc2 = arepo.findByaccountid(toAccount);
		var currbalance = acc1.getBalance();
		if(currbalance>amount) {
			acc1.setBalance(currbalance-amount);
			var currbalance1 = acc2.getBalance();
			acc2.setBalance(currbalance1+amount);
			arepo.save(acc1);
			arepo.save(acc2);
			return true;
			}
		return false;
	}
	
	@Override
	public boolean validateAccount(long id, String password) {
		return arepo.findByaccountid(id).getPassword().equals(password);
			
	}

}
