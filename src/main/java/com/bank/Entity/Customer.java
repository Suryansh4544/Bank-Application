package com.bank.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Customer implements Serializable{
	@Id
	long customerid;
	String customername;
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Customer(int customerid, String customername) {
		super();
		this.customerid = customerid;
		this.customername = customername;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "customer [customerid=" + customerid + ", customername=" + customername + "]";
	}
	
}
