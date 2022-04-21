package com.bank.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Services.TransactionService;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionService tservice;
	
	@PutMapping("/withdraw")
	public ResponseEntity<Double> withdraw(@RequestBody Map<String, ?> json) {
		try {
			long accountid = ((Number) json.get("accountid")).longValue();
			double balance = ((Integer)json.get("amount")).doubleValue();
			String password = (String) json.get("password");
			if(tservice.validateAccount(accountid, password))
				return new ResponseEntity<>(tservice.withdraw(accountid, balance),HttpStatus.OK);
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/deposit")
	public ResponseEntity<Double> deposit(@RequestBody Map<String, ?> json) {
		try {
			long accountid = ((Number) json.get("accountid")).longValue();
			double balance = ((Integer)json.get("amount")).doubleValue();
			String password = (String) json.get("password");
			if(tservice.validateAccount(accountid, password))
				return new ResponseEntity<>(tservice.deposit(accountid, balance),HttpStatus.OK);
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/getBalance")
	public ResponseEntity<Double> getBalance(@RequestBody Map<String, ?> json) {
		try {
			String password = (String) json.get("password");
			long accountid = ((Number) json.get("accountid")).longValue();
			if(tservice.validateAccount(accountid, password))
				return new ResponseEntity<>(tservice.getBalance(accountid),HttpStatus.OK);
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/fundTransfer")
	public ResponseEntity<Boolean> fundTransfer(@RequestBody Map<String, ?> json) {
		try {
			long fromaccountid = ((Number) json.get("fromaccountid")).longValue();
			long toaccountid = ((Number) json.get("toaccountid")).longValue();
			double balance = ((Integer)json.get("amount")).doubleValue();
			String password = (String) json.get("password");
			if(tservice.validateAccount(fromaccountid, password))
				return new ResponseEntity<>(tservice.fundTransfer(fromaccountid,toaccountid, balance),HttpStatus.OK);
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
