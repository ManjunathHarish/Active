package com.bank.accounts.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bank.accounts.ExceptionHandling.BadRequestException;
import com.bank.accounts.collections.AccountModels.AccountDetails;
import com.bank.accounts.collections.UserModel.UserDetails;
import com.bank.accounts.collections.UserModel.UserDetailsListResult;
import com.bank.accounts.collections.UserModel.UserDetailsResult;
import com.bank.accounts.databaseStorage.UserDetailsStorage;

@Path("users")
public class UserDetailsController {
	UserDetailsStorage rep=new UserDetailsStorage();
	UserDetailsResult output=new UserDetailsResult();
	UserDetailsListResult listOutput=new UserDetailsListResult();

//for get all accounts in a table
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public UserDetailsListResult getAllAccounts()
	{
		List<UserDetails> o=null;
		try {
			o=rep.getAllUsersDetails();
			listOutput.setData(o);
			listOutput.setStatus("success");
			listOutput.setDescription("All information regarding users");
			return listOutput;
		}
		catch(BadRequestException e){
			listOutput.setData(o);
			listOutput.setStatus("faillure");
			listOutput.setDescription("no data found");
			return listOutput;
		}
	}

//for getting user information based on id
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public UserDetailsResult getUserInfoByUserid(@PathParam("id") int id)
	{
		UserDetails o=null;
		try {
			o=rep.getUserInfoByUserid(id);
			output.setData(o);
			output.setDescription("Your information of id="+id);
			output.setStatus("success");
			return output;
		}
		catch(BadRequestException e){
			output.setDescription("no information found on your searching id");
			output.setStatus("faillure");
			return output;
		}
	}
//for insert new user in the table
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON})
	public UserDetailsResult CreateAccount(UserDetails a)
	{
		UserDetails o=null;
		try {
			o=rep.CreateUser(a);
			output.setData(o);
			output.setDescription("Thank you for creating ur account");
			output.setStatus("success");
			return output;
		}
		catch(Exception e){
			output.setDescription("Already an account is created by this user id please try with different");
			output.setStatus("faillure");
			return output;
		}
	}


//for updating email
	@PUT
	@Path("/updateEmail/{id}/{email}")
	@Produces({MediaType.APPLICATION_JSON})
	public UserDetailsResult UpdateEmail(@PathParam("id") int id,@PathParam("email") String email)
	{
		UserDetails o=null;
		try {
			o=rep.UpdateEmail(id,email);
			output.setStatus("success");
			output.setDescription("Your email is updated thank you");
			output.setData(o);
			return output;
		}
		catch(Exception e){
			output.setStatus("faillure");
			output.setDescription("something went wrong!, please try again");
			return output;
		}
	}
	
//for updating email
	@PUT
	@Path("/updatePhoneNumber/{id}/{phoneNumber}")
	@Produces({MediaType.APPLICATION_JSON})
	public UserDetailsResult UpdatePhoneNumber(@PathParam("id") int id,@PathParam("phoneNumber") int phoneNumber)
	{
		UserDetails o=null;
		try {
			o=rep.UpdatePhoneNumber(id,phoneNumber);
			output.setStatus("success");
			output.setDescription("Your phone number is updated thank you");
			output.setData(o);
			System.out.println("resulto"+o);
			return output;
		}
		catch(Exception e){
			output.setStatus("faillure");
			output.setDescription("something went wrong!, please try again");
			System.out.println("error");
			return output;
		}
	}
}
