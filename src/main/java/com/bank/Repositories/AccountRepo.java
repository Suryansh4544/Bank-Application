package com.bank.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.Entity.Account;

public interface AccountRepo extends JpaRepository<Account,Long>{
	Account findByaccountid(long id);
}
