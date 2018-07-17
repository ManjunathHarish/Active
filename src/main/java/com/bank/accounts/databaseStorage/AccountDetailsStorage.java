
package com.bank.accounts.databaseStorage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

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

	 public List<AccountDetails> getAllAccounts() throws Exception,BadRequestException
	 {
		 try {
			 //if u want every details about account
			 String hql = "FROM AccountDetails";
			 Query query = con.s.createQuery(hql);
			 List<AccountDetails> list = query.list();
			 //if u dont want customer details
//			 Criteria cr = con.s.createCriteria(AccountDetails.class)
//					    .setProjection(Projections.projectionList()
//					      .add(Projections.property("account_number"), "account_number")
//					      .add(Projections.property("balance"), "balance"))
//					    .setResultTransformer(Transformers.aliasToBean(AccountDetails.class));
//					  List<AccountDetails> list = cr.list();
					  con.s.close();
			 if(list.size()!=0)
			 return list;
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
			 con.s.close();
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
			 String hql = "FROM AccountDetails WHERE customer.id="+id;
			 Query query = con.s.createQuery(hql);
			 List results = query.list();
			 con.s.close();
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
			 con.s.close();
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
