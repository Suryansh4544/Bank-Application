package com.bank.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.Entity.Customer;
import com.bank.Services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService cservice;
	
	@PostMapping("/newcustomer")
	public ResponseEntity<Customer> newcustomer(@RequestBody Customer c){
		try {
			cservice.saveCustomer(c);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getcustomers")
	public ResponseEntity<List<Customer>> getcustomer(){
		try {
			return new ResponseEntity<>(cservice.fetchCustomer(),HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updatecustomer(@RequestBody Customer c){
		try {
			if(cservice.updateCustomer(c, c.getCustomerid()))
				return new ResponseEntity<>(c,HttpStatus.OK);
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletecustomer/{pid}")
	public ResponseEntity<Customer> deletecustomer(@PathVariable Long pid){
		try {
			Customer c = cservice.deleteCustomer(pid);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getcustomerbyid/{pid}")
	public ResponseEntity<Customer> getcustomerbyid(@PathVariable Long pid){
		try {
			Customer c = cservice.fetchCustomerById(pid);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
