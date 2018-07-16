package com.bank.accounts.collections.AccountModels;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.bank.accounts.collections.UserModel.UserDetails;



//@XmlRootElement
@Entity
@Table(name = "account_details")
public class AccountDetails {
	
	@Id
	private int account_number;
	private int balance;
	@ManyToOne
	private UserDetails customer;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public UserDetails getCustomer() {
		return customer;
	}
	public void setCustomer(UserDetails customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "AccountDetails [account_number=" + account_number + ", balance=" + balance + ", customer=" + customer
				+ "]";
	}
	
	
}
