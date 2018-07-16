
package com.bank.accounts.databaseStorage;

import java.util.List;

import org.hibernate.query.Query;
import com.bank.accounts.ExceptionHandling.BadRequestException;
import com.bank.accounts.collections.AccountModels.AccountDetails;


public class AccountDetailsStorage{
	List<AccountDetails> account;
		SQLConfiguration con=new SQLConfiguration();

	 public void addAccount(AccountDetails a) throws BadRequestException
	 {
		 try {
			 con.s.save(a);
			 con.transaction.commit();
		 }
		 catch(Exception e){
			 throw new BadRequestException("Account Number Is already Existed");
		 }
	 }

	 public List<AccountDetails> getAllAccounts() throws Exception
	 {
		 try {
			 String hql = "FROM AccountDetails";
			 Query query = con.s.createQuery(hql);
			 List results = query.list();
			 if(results.size()!=0)
			 return results;
			 throw new BadRequestException("no data found");
		 }
		 catch(BadRequestException e)
		 {
			 throw new BadRequestException(e);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	}
	 
	 public AccountDetails getAccountByAccountNumber(int id) throws BadRequestException
	 {
		 try {
			 AccountDetails a=con.s.get(AccountDetails.class, id);
			 if(a!=null)			 
			 return a;
			 throw new BadRequestException("Account Not Foud of ID="+id);
		 }
		 catch(BadRequestException e){
			 e.printStackTrace();
			 throw new BadRequestException(e);
		 }
	 }
	 
	 public List<AccountDetails> userAccounts(int id) throws BadRequestException
	 {
		 try {
			 String hql = "FROM AccountDetails WHERE user_id="+id;
			 Query query = con.s.createQuery(hql);
			 List results = query.list();
			 System.out.println(results);
			 if(results.size()!=0)
				 return results;
			 throw new BadRequestException("no user found");
		 }
		 catch(BadRequestException e)
		 {
			 throw new BadRequestException(e);
		 }
	 }
	 
	 public void DeleteAccount(int id) throws BadRequestException
	 {
		 try {
			 String hql = "DELETE FROM AccountDetails "  + 
		             "WHERE account_number=:account_number";
			 Query query = con.s.createQuery(hql);
			 query.setParameter("account_number", id);
			 int result = query.executeUpdate();
			 System.out.println(result);
			 if(result==0)
				 throw new BadRequestException("no account found in the id="+id);
		 }
		 catch(BadRequestException e)
		 {
			 e.printStackTrace();
			 throw new BadRequestException(e);
		 }
	 }
	 
	 
}
