package com.revature._611.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.revature._611.beans.User;
import com.revature._611.services.UserService;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage( ModelMap model ) 
	{
		return new ModelAndView("");
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)	
	public @ResponseBody String login(@RequestBody User tempUser)  
	{	
		// Check received user from Angular post
		System.out.println("Requested user: name=" + tempUser.getUsername() + " pass=" + tempUser.getPassword());
		
		boolean success = UserService.doCommand("Login", tempUser);
		
		if (success)
		{
			System.out.println("Successful login! Returning 'ok'");
			return "ok";
		}else {
			System.out.println("Oh, snap! Login failed.. Returning 'bad'");
			return "bad";
		}
	}
}
