package com.bank.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
	Customer findBycustomerid(long id); 
}
