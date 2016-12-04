package com.revature._611.dao;

import com.revature._611.beans.User;
import com.revature._611.utils.HibernateUtil;

/**
 * 2016/12/01
 * User DAO Interface for first sprint of Project 2: Splice Game. <br>
 * 
 * @author Ric Smith
 * @author Matt Pierzynski
 * @version 1.0
 */
public interface UserDAO {

	boolean registerNewUser(User usr);
	
	User userLogin(User usr);
	
}