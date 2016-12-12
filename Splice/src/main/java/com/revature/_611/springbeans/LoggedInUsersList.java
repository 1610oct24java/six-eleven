package com.revature._611.springbeans;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;


public class LoggedInUsersList {
	private ArrayList usersList = new ArrayList();
	
	public ArrayList getUsersList() {
		return usersList;
	}

	public boolean addUser(String username) {
		return this.usersList.add(username);
	}
	
	public void setUsersList(ArrayList<String> usersList) {
		this.usersList = usersList;
	}
}