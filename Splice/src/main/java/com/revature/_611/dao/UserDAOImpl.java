package com.revature._611.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature._611.beans.User;
import com.revature._611.utils.HibernateUtil;

/**
 * 2016/12/01
 * User DAO Implementation for first sprint of Project 2: Splice Game. <br>
 * 
 * @author Ric Smith
 * @author Matt Pierzynski
 * @author Ryan Lawson
 * @version 1.0
 */

public class UserDAOImpl implements UserDAO {

	private static HibernateUtil hu = new HibernateUtil();

	@Override
	public boolean registerNewUser(User usr) {
		
		ArrayList<User> users;
		
		Session session;
		Query query;
		
		session = hu.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "FROM User AS u WHERE u.username = :usr";
		query = session.createQuery(hql);
		query.setParameter("usr", usr.getUsername());
		users = (ArrayList<User>) query.list();
		if(users.size()>0)
		{
			trans.rollback();
			session.close();
			return false;
		}

		session.save(usr);
		
		trans.commit();
		
		session.close();
		
		return true;
	}

	@Override
	public User userLogin(User usr) {
		
		ArrayList<User> users;
		User user = null;
		
		Session session;
		Query query;
		
		session = hu.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "FROM User AS u WHERE u.username = :usr AND u.password = :pwd";
		query = session.createQuery(hql);
		query.setParameter("usr", usr.getUsername());
		query.setParameter("pwd", usr.getPassword());
		users = (ArrayList<User>) query.list();
		for(User u : users)
			user = u;
		
		if(user == null){
			trans.rollback();
			session.close();
			return null;
		}
		
		session.save(user);
		trans.commit();
		
		session.close();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() 
	{
		List<User> users = null;
		
		Session session = hu.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		
		users = (ArrayList<User>) query.list();
		
		trans.commit();
		session.close();
		
		return users;
	}
}