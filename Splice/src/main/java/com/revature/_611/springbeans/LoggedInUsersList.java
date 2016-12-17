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
	
	public String toJsonString() {
		System.out.println(usersList.toString());
		
		StringBuilder jsonString = new StringBuilder();
		
		jsonString.append("{ \"users\": [");
		for (int i = 0; i < usersList.size(); i++) {
			jsonString.append("\"" + usersList.get(i) + "\"");
			if (i < usersList.size() - 1) {
				jsonString.append(", ");
			}
		}
		jsonString.append("]}");
		
		System.out.println("UsersList JSON: " + jsonString.toString());
		return jsonString.toString();
	}
}