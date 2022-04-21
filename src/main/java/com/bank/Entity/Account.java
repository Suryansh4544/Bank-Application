package com.bank.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Account implements Serializable {
	@Id
	private long accountid;
	private double balance=-1;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer owner;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAccountid() {
		return accountid;
	}
	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getOwner() {
		return owner;
	}
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	public Account(int accountid, int balance, Customer owner, String password) {
		this.accountid = accountid;
		this.balance = balance;
		this.owner = owner;
		this.password = password;
	}
	public Account() {
	}
	
}
