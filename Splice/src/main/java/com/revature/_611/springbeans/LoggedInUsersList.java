package com.revature._611.springbeans;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;


public class LoggedInUsersList {
	private ArrayList<String> usersList = new ArrayList<String>();
	
	public ArrayList<String> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<String> usersList) {
		this.usersList = usersList;
	}


	
	
}
