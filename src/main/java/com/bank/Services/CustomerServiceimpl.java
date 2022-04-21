package com.bank.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.Customer;
import com.bank.Repositories.CustomerRepo;

@Service
public class CustomerServiceimpl implements CustomerService{

	@Autowired
	CustomerRepo repo;
	
	@Override
	public void saveCustomer(Customer c) {
		repo.save(c);
	}

	@Override
	public List<Customer> fetchCustomer() {
		return repo.findAll();
	}

	@Override
	public boolean updateCustomer(Customer c, long pid) {
		if(repo.findBycustomerid(pid)!=null) {
			repo.save(c);
			return true;
		}
		return false;
	}

	@Override
	public Customer deleteCustomer(long pid) {
		Customer c = repo.getById(pid); 
		repo.deleteById(pid);
		return c;
	}

	@Override
	public Customer fetchCustomerById(long id) {
		return repo.getById(id);
	}
	

}
