package com.revature._611.dao;

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
 * @version 1.0
 */
public class UserDAOImpl implements UserDAO {

	private static HibernateUtil hu = new HibernateUtil();

	@Override
	public boolean registerNewUser(User usr) {
		
		boolean success = false;
		
		Session sesh = hu.getSession();
		Transaction trans = sesh.beginTransaction();
		
		//TODO check if username is available
		sesh.save(usr);
		trans.commit();
		
		sesh.close();
		
		return success;
	}

	@Override
	public User userLogin(User usr) {
		// TODO Auto-generated method stub
		return null;
	}
}
