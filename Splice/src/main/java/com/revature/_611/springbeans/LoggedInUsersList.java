package com.revature._611.springbeans;

import java.util.ArrayList;
import java.util.Collections;


public class LoggedInUsersList {
	private ArrayList<String> usersList = new ArrayList<>();
	
	public ArrayList<String> getUsersList() {
		return usersList;
	}

	public boolean addUser(String username) {
		boolean status = false;
		
		System.out.println("Adding: " + username);
		
		status = usersList.add(username);
		
		return status;
	}
	
	public void setUsersList(ArrayList<String> usersList) {
		this.usersList = usersList;
		Collections.synchronizedList(usersList);
	}
}