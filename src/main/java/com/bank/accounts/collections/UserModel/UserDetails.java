package com.bank.accounts.collections.UserModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.bank.accounts.collections.AccountModels.AccountDetails;


//@XmlRootElement
@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private String email;
	private long phone_number;
	@OneToMany(mappedBy="customer")
	private List<AccountDetails> accounts=new ArrayList<AccountDetails>();
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", phone_number=" + phone_number + "]";
	}
	
	
}
