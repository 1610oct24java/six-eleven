package com.revature._611.controllers;

import com.revature._611.beans.User;
import com.revature._611.services.UserService;
import com.revature._611.springbeans.LoggedInUsersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	LoggedInUsersList usersOnline;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(ModelMap model) {
		return new ModelAndView("");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody User tempUser, HttpServletRequest request) {
		// Check received user from Angular post
		System.out.println("Requested user: name=" + tempUser.getUsername() + " pass=" + tempUser.getPassword());
		boolean success = UserService.doCommand("Login", tempUser);

		if (success) {
			System.out.println("Successful login! Returning 'ok'");
			addUser(tempUser.getUsername());
			System.out.println("Trying to add: " + tempUser.getUsername());
			return "{\"success\":\"ok\"}";
		} else {
			System.out.println("Oh, snap! Login failed.. Returning 'bad'");
			return "{\"success\":\"bad\"}";
		}
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)	
	public @ResponseBody String register(@RequestBody User tempUser)
	{	
		// Check received user from Angular post
		System.out.println("Registering user: name=" + tempUser.getUsername() + " pass=" + tempUser.getPassword());
		
		boolean success = UserService.doCommand("Register", tempUser);
		
		if (success)
		{
			System.out.println("Successful registration! Returning 'ok'");
			return "{\"success\":\"ok\"}";
		}else {
			System.out.println("Oh, snap! Registration failed.. Returning 'bad'");
			return "{\"success\":\"bad\"}";
		}
	}


	// Adds the username to the synchronized list of the logged in user
	private void addUser(String username) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			for(String s : usersOnline.getUsersList()){
				System.out.println("Contains " + s);
			}
			usersOnline.addUser(username);
		}
	}
}
