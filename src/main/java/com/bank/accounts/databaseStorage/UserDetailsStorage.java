package com.bank.accounts.databaseStorage;
import java.util.List;

import org.hibernate.query.Query;

import com.bank.accounts.ExceptionHandling.BadRequestException;
import com.bank.accounts.collections.UserModel.UserDetails;

public class UserDetailsStorage {

	SQLConfiguration con=new SQLConfiguration();
    
//for get all user information
	public List<UserDetails> getAllUsersDetails() throws BadRequestException
	{
		try {
			String hql = "FROM UserDetails";
			 Query query = con.s.createQuery(hql);
			 List results = query.list();
			 if(results.size()!=0)
			 return results;
			 throw new BadRequestException("no data found");
		}
		catch(BadRequestException e){
			throw new BadRequestException(e);
		}
	}
	
//for create new user
	public UserDetails CreateUser(UserDetails a) throws Exception
	{
		try {
			con.s.save(a);
			con.transaction.commit();
			return a;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
//for get user information based on userid
	 public UserDetails getUserInfoByUserid(int id) throws BadRequestException
	 {
		 try {
			 UserDetails o=con.s.get(UserDetails.class, id);
			 if(o!=null)
				 return o;			
			 throw new BadRequestException("no informatin found on ID="+id);
		 }
		 catch(BadRequestException e){
			 throw new BadRequestException(e);
		 }
	 }
	 
	 public UserDetails UpdateEmail(int id,String email) throws Exception
	 {
		 try {
			 String hql = "UPDATE UserDetails set email = :email "  + 
		             "WHERE id = :user_id";
			 Query query = con.s.createQuery(hql);
			 query.setParameter("email", email);
			 query.setParameter("user_id", id);
			 query.executeUpdate();
			 return con.s.get(UserDetails.class, id);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 
	 public UserDetails UpdatePhoneNumber(int id,int phoneNumber) throws Exception
	 {
		 System.out.println("hi");
		 try {
			 String hql = "UPDATE UserDetails set phone_number = :phone_number "  + 
		             "WHERE id = :user_id";
			 System.out.println("hi");
			 Query query = con.s.createQuery(hql);
			 query.setParameter("phone_number", phoneNumber);
			 query.setParameter("user_id", id);
			 query.executeUpdate();
			 UserDetails o=con.s.get(UserDetails.class, id);
			 System.out.println("re"+o);
			 return o;
		 }
		 catch(Exception e){
			 System.out.println("error");
			 throw e;
		 }
	 }

}
