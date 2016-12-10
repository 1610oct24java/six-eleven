package com.revature._611.dao;

import java.util.List;

import com.revature._611.beans.User;

/**
 * 2016/12/01
 * User DAO Interface for first sprint of Project 2: Splice Game. <br>
 * 
 * @author Ric Smith
 * @author Matt Pierzynski
 * @version 1.0
 */
public interface UserDAO {

	// CREATE
	public boolean registerNewUser(User usr);
	
	// READ
	public User userLogin(User usr);
	public List<User> getUsers();
	
}