package com.bank.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.*;

import com.bank.Entity.Account;
import com.bank.Services.AccountService;
import com.bank.Services.CustomerService;
import com.bank.Services.StandardJsonResponse;
import com.bank.Services.StandardJsonResponseImpl;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService aservice;
	
	@Autowired
	CustomerService cservice;
	
	@Autowired
	StandardJsonResponse jsonResponse;
	
	@PostMapping("/newaccount")
	public ResponseEntity<StandardJsonResponse>  newaccount(@RequestBody Account a){
		try {
			aservice.saveAccount(a);
			jsonResponse.setData(a);
			jsonResponse.setSuccess(true);
			jsonResponse.setHttpResponseCode(HttpStatus.OK.value());
			return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
		}
		catch(JpaObjectRetrievalFailureException e) {
			cservice.saveCustomer(a.getOwner());
			aservice.saveAccount(a);
			jsonResponse.setData(a);
			jsonResponse.setSuccess(true);
			jsonResponse.setHttpResponseCode(HttpStatus.OK.value());
			return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			jsonResponse.setSuccess(false,e.getMessage());
			jsonResponse.setData(a);
			jsonResponse.setHttpResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(jsonResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getaccounts")
	public ResponseEntity<List<Account>> getaccounts(){
		try {
			return new ResponseEntity<>(aservice.fetchAccount(),HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateaccount")
	public ResponseEntity<Account> updateaccount(@RequestBody Account a){
		try {
			if(aservice.updateAccount(a, a.getAccountid())) {
				return new ResponseEntity<>(a,HttpStatus.OK);
			}
			return new ResponseEntity<>(null,HttpStatus.CONFLICT);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteaccount/{pid}")
	public ResponseEntity<Account> deleteaccount(@PathVariable long pid){
		try {
			Account acc = aservice.deleteAccount(pid);
			return new ResponseEntity<>(acc,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getaccount/{pid}")
	public ResponseEntity<Account> getaccountbyid(@PathVariable long pid){
		try {
			Account acc = aservice.fetchAccountById(pid);
			if(acc!=null)
				return new ResponseEntity<>(acc,HttpStatus.OK);
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
