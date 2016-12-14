package com.revature._611.utils;

import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 2016/12/01
 * Hibernate Utility Class for first sprint of Project 2: Splice Game. <br>
 * This utility serves as a factory to retrieve a hibernate session. <br>
 * Using: Hibernate, Serializable <br>
 * Overrides: toString(), hashCode(), equals()
 * 
 * @author Ric Smith
 * @author Matt Pierzynski
 * @version 1.0
 */

@Aspect
public class HibernateUtil
{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			//make a new one
			Configuration conf = new Configuration().configure();
			ServiceRegistry serviceRegistry =
					new StandardServiceRegistryBuilder()
						.applySettings(conf.getProperties())
						.build();
			//Build a session factory from the service registry
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	
	public Session getSession()
	{
		return this.getSessionFactory().openSession();
	}
	
	@Override
	protected void finalize() throws Throwable 
	{
		sessionFactory.close();
		super.finalize();
	}
	
}