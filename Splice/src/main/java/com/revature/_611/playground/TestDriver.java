package com.revature._611.playground;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.revature._611.beans.Creature;
import com.revature._611.beans.Sorcerer;
import com.revature._611.beans.User;
import com.revature._611.dao.CardDAOimp;
import com.revature._611.dao.UserDAOImpl;

public class TestDriver {
	
	public static void main(String[] args) {
		
		UserDAOImpl userDao = new UserDAOImpl();
		
		User u1 = new User("pski","poop");
		
		System.out.println(userDao.login(u1));
		
	}

}
