package com.bank.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bank.Entity.Customer;


@Service
public interface CustomerService {
	public void saveCustomer(Customer c);
	public List<Customer> fetchCustomer();
	public boolean updateCustomer(Customer c, long pid);
	public Customer deleteCustomer(long pid);
	public Customer fetchCustomerById(long id);
}