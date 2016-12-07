package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature._611.beans.User;

@Component
public class UserService {
	
	//TODO make this match our project
	public User login(User user) {
		User authUser = null;
		if ("john".equals(user.getUsername()) && "pass".equals(user.getPassword())) {
			authUser = user;
		} else {
			authUser = null;
		}
		return authUser;
	}
}