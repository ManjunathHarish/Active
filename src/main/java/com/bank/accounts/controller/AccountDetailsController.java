package com.bank.accounts.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.bank.accounts.ExceptionHandling.BadRequestException;
import com.bank.accounts.collections.AccountModels.AccountDetails;
import com.bank.accounts.collections.AccountModels.AccountResult;
import com.bank.accounts.collections.AccountModels.NormalAccountResult;
import com.bank.accounts.databaseStorage.AccountDetailsStorage;

@Path("/accounts")
public class AccountDetailsController {
	AccountDetailsStorage rep=new AccountDetailsStorage();
	AccountResult r=new AccountResult();
	NormalAccountResult normalAccountResult=new NormalAccountResult();
	
//for get all accounts in a table
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public AccountResult getAllAccounts()
	{
		List<AccountDetails> o;
		
		try {
			o = rep.getAllAccounts();
			r.setData(o);
				r.setStatus("success");
				r.setDescription("Information about all accounts");
				return r;
		} catch (BadRequestException e) {
			e.printStackTrace();
			r.setStatus("faillure");
			r.setDescription("no data found");
			return r;
		}catch(Exception e) {
			e.printStackTrace();
			r.setDescription("something went wrong");
			return r;
		}
	}
	
//for get all accounts of specific user
	@GET
	@Path("/user/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public AccountResult accountOfUser(@PathParam("id") int id)
	{
			try {
				List<AccountDetails> o=rep.userAccounts(id);
				System.out.println("result"+o);
				r.setData(o);
				r.setStatus("success");
				r.setDescription("Information about accounts of id="+id);
				return r;
			} catch (BadRequestException e) {
				r.setStatus("faillure");
				r.setDescription("no user found with id="+id);
				return r;
			}
	}
	
//for insert new accounts in the table
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces("text/plain")
	public String CreateAccount(AccountDetails a)
	{
			try {
				rep.addAccount(a);
				return "successfully created new account";
			} catch (BadRequestException e) {
				e.printStackTrace();
				return "Account Number Is already Existed";
			}
			
		
	}
	
//for delete account details in a table
	@DELETE
	@Path("/{id}")
	@Produces("text/plain")
	public String deletAccount(@PathParam("id") int id)
	{
		try {
			rep.DeleteAccount(id);
			return "successfully deleted your account account";
		}
		catch(BadRequestException e){
			return "no account found in the id="+id;
		}
	}
	
//for getting each account data by its number
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public NormalAccountResult getAccountByAccountNumber(@PathParam("id") int id)
	{
		AccountDetails o=null;
		try {
			o=rep.getAccountByAccountNumber(id);
			normalAccountResult.setData(o);
			normalAccountResult.setStatus("success");
			normalAccountResult.setDescription("Account Details of ID="+id);
			return normalAccountResult;
		}
		catch(BadRequestException e){
			normalAccountResult.setData(o);
			normalAccountResult.setStatus("faillure");
			normalAccountResult.setDescription("Account Not Foud of ID="+id);
			return normalAccountResult;
		}

	}

}
