package com.bank.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.Account;
import com.bank.Repositories.AccountRepo;

@Service
public class AccountServiceimpl implements AccountService{
	@Autowired
	AccountRepo arepo;
	
	@Override
	public void saveAccount(Account a) {
		arepo.save(a);
	}

	@Override
	public List<Account> fetchAccount() {
		List<Account> accounts = arepo.findAll();
		accounts.forEach(s->s.setPassword("*"));
		return accounts;
	}

	@Override
	public boolean updateAccount(Account a, long pid) {
		if(arepo.findByaccountid(pid)!=null) {
			Account oldacc = arepo.getById(pid);
			if(a.getBalance()==-1) a.setBalance(oldacc.getBalance());
			if(a.getOwner()==null) a.setOwner(oldacc.getOwner());
			if(a.getPassword()==null) a.setPassword(oldacc.getPassword());
			arepo.save(a);
			a.setPassword("*");
			return true;
		}
		return false;
	}

	@Override
	public Account deleteAccount(long pid) {
		Account acc = arepo.findByaccountid(pid);
		arepo.deleteById(pid);
		return acc;
	}

	@Override
	public Account fetchAccountById(long id) {
		Account acc =  arepo.findByaccountid(id);
		if(acc!=null)
		acc.setPassword("*");
		return acc;
	}

	
}
