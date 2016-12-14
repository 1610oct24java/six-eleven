package com.revature._611.services;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature._611.beans.User;
import com.revature._611.dao.UserDAOImpl;

@Aspect
@Component
public class UserService {
	
	private static final String LOGIN = "Login";
	private static final String LOGOUT = "Logout";
	private static final String REGISTER = "Register";

	public static boolean doCommand(String command, User tempUser)
	{
		UserDAOImpl userDao = new UserDAOImpl();
		boolean success = false;
		
		switch (command)
		{
		case LOGIN:
			User authUser = userDao.userLogin(tempUser);
			
			if(authUser == null)
			{
				success = false;
			}else {
				// login if equal
				if(tempUser.getUsername().equalsIgnoreCase(authUser.getUsername()) 
						&& tempUser.getPassword().equals(authUser.getPassword()))
				{
					success = true;
				}else{
					success = false;
				}
			}
			break;
			
		case REGISTER:
			success = userDao.registerNewUser(tempUser);
			break;

		case LOGOUT: // may not need this for spring here
			break;
		
		default:
			break;
		}
		
		return success;
	}
}
