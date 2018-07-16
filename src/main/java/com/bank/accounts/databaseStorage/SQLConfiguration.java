package com.bank.accounts.databaseStorage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.bank.accounts.collections.AccountModels.AccountDetails;
import com.bank.accounts.collections.UserModel.UserDetails;

import org.hibernate.cfg.Configuration;

public class SQLConfiguration {
	Configuration config=new Configuration().configure().addAnnotatedClass(AccountDetails.class).addAnnotatedClass(UserDetails.class);
	ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    SessionFactory sf=config.buildSessionFactory(sr);
    Session s=sf.openSession();
    Transaction transaction=s.beginTransaction();
}
