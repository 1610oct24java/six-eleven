package com.revature._611.logic;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.revature._611.beans.User;
import com.revature._611.dao.UserDAOImpl;

public class Commands {
	private static final String LOGIN = "Login";
	private static final String LOGOUT = "Logout";
	private static final String Register = "Register";
	
	public static void doCommand(JSONObject json, HttpSession session, PrintWriter out){
		JSONObject data = json.getJSONObject("Data");
		String command = json.getString("Command");
		UserDAOImpl userDao = new UserDAOImpl();
		
		switch (command){
		case LOGIN:{
			String username = data.getString("username");
			String password = data.getString("password");
			User user = new User(username, password);
			User loggedInUser = userDao.userLogin(user);
			
			if(loggedInUser == null){
				loggedInUser = new User("bad","login");
			}
			// login if equal
			if(username.equals(loggedInUser.getUsername()) && password.equals(loggedInUser.getPassword())){
				session.setAttribute("loggedIn", "true");
				session.setAttribute("username", username);
			}else{
				session.setAttribute("loggedIn", "false");
			}
			break;
		}case LOGOUT:{
			if(session.getAttribute("loggedIn").equals("true")){
				session.invalidate();
			}
			System.out.println("Logging Out");
			break;
		}
		
		}
	}
}