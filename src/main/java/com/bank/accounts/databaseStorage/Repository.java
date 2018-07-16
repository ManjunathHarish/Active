package com.bank.accounts.databaseStorage;

import java.util.List;

import org.hibernate.query.Query;

public class Repository {
	SQLConfiguration con=new SQLConfiguration();
	public List<Object> getAllDetails() {
		System.out.println("calling");
		String hql="SELECT * from UserDetails AccountDetails";
		Query query = con.s.createQuery(hql);
		List<Object> results = query.list();
		System.out.println("gotcha"+results);
		return results;
	}
}
