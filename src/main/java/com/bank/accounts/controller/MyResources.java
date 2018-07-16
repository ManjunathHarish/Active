package com.bank.accounts.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bank.accounts.collections.UserModel.TotalResult;
import com.bank.accounts.collections.UserModel.UserDetailsListResult;
import com.bank.accounts.collections.UserModel.UserDetailsResult;
import com.bank.accounts.databaseStorage.Repository;
import com.bank.accounts.databaseStorage.UserDetailsStorage;

@Path("/total")
public class MyResources {
	Repository rep=new Repository();
	TotalResult output=new TotalResult();
	UserDetailsListResult listOutput=new UserDetailsListResult();
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Object> getAllDetail()
	{
		return rep.getAllDetails();
		
	}

}
