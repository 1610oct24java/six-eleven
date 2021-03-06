package com.revature._611.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature._611.beans.Message;
import com.revature._611.beans.User;
import com.revature._611.dao.UserDAOImpl;
import com.revature._611.springbeans.Lobby;
import com.revature._611.springbeans.LobbyList;

@Controller
public class QueueController {
	
	@Autowired
	LobbyList myLobbies;
	
	@RequestMapping(value="/getUsersInLobby", method = RequestMethod.POST)
	public @ResponseBody String getUsersInLobby (@RequestBody String lobbyName) {
		System.out.println("BEHOLD!");
		String output = "";
		
		Lobby l = myLobbies.getLobbyByName(lobbyName);
		output = l.getUsersAsJson();
		
		System.out.println("User List: " + output);
		
		return output;
	}

	@RequestMapping(value="/getUsersInQueue", method = RequestMethod.GET)	
	public @ResponseBody String getOnlineUsers(@RequestBody User tempUser) {	
		System.out.println("BEHOLD MY SPLENDOR");
		UserDAOImpl userDAO = new UserDAOImpl();
		
		List<User> users = userDAO.getUsers();
		
		// Create a JSON string of this structure to return only user names
		// [{"player":"one"},{"player":"two"}]
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for (int i=0; i < users.size(); i++)
		{
			sb.append("{'player':'"+users.get(i).getUsername()+"'}");
			
			if (i < users.size()-1)
			{
				sb.append(",");
			}
		}
		
		sb.append("]");
		
		// Check this JSON here...
		System.out.println("Player list: " + sb.toString());
		
		return sb.toString(); 
	}
	
	@RequestMapping(value="/sendQueueMessage", method = RequestMethod.POST)
	public @ResponseBody String sendMessage(@RequestBody Message msg)  
	{	
		// Check received user from Angular post
		System.out.println("Receive message: sender=" + msg.getSender() + " content=" + msg.getContent());
		
		// ADD MESSAGE TO SESSION OR APPLICATION LIST<MESSAGE>
		
		boolean success = false; // Message successfully receive and stored in application?
		
		if (success)
		{
			System.out.println("Message received! Returning 'ok'");
			return "ok";
		}else {
			System.out.println("Oh, snap! Message lost.. Returning 'bad'");
			return "bad";
		} 
	}
}