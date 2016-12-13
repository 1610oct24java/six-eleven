package com.revature._611.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature._611.beans.Message;
import com.revature._611.springbeans.Lobby;
import com.revature._611.springbeans.LobbyList;
import com.revature._611.springbeans.LoggedInUsersList;

@Controller
public class LobbyController {

	@Autowired
	LoggedInUsersList usersOnline;
	@Autowired
	LobbyList myLobbies;

	@RequestMapping(value="/getOnlineUsers", method = RequestMethod.GET)	
	public @ResponseBody String getOnlineUsers()  {
		
		List<String> usersList = usersOnline.getUsersList();
		System.out.println("ONE: " );
		for(String s : usersOnline.getUsersList()){
			System.out.println("1 Contains: " + s);
		}
		System.out.println("TWO: " );
		for(String s : usersList){
			System.out.println("2 Contains: " + s);
		}
		
		// Create a JSON string of this structure to return only user names
		// {"players":[{"player":"one"},{"player":"two"}]}
		StringBuilder jsonString = new StringBuilder();
		
		// head of json string:
		jsonString.append("{\"players\":[");
		
		// build players into the players JSON array:
		for (int i=0; i < usersList.size(); i++){
			jsonString.append("{\"player\":\" ");
			jsonString.append(usersList.get(i));
			jsonString.append( "\"}");
			// add a comma if there is an extra player
			if (i < usersList.size()-1){
				jsonString.append(",");
			}
		}
		// Add the end of the JSON string
		jsonString.append("]}");
		
		// Check the JSON here...
		System.out.println("**Player JSON list: " + jsonString.toString());
		return jsonString.toString(); 
	}
	
	@RequestMapping(value = "/lobbyCtrl", method = RequestMethod.POST)
	public @ResponseBody String createLobby(@RequestBody Lobby newLobby) {
		// newLobby is a new Lobby object

		myLobbies.addLobby(newLobby);

		return myLobbies.toJsonString();
	}

	@RequestMapping(value = "/lobbyCtrl", method = RequestMethod.GET)
	public @ResponseBody String getLobby() {
		return myLobbies.toJsonString();
	}

	@RequestMapping(value="/sendLobbyMessage", method = RequestMethod.POST)
	public @ResponseBody String sendMessage(@RequestBody Message msg)
	{
		// Check received user from Angular post
		System.out.println("Receive message: sender=" + msg.getSender() + " content=" + msg.getContent());
		
		// ADD MESSAGE TO SESSION OR APPLICATION LIST<MESSAGE>
		
		boolean success = false; // Message successfully receive and stored in application?
		
		if (success){
			System.out.println("Message received! Returning 'ok'");
			return "ok";
		}else {
			System.out.println("Oh, snap! Message lost.. Returning 'bad'");
			return "bad";
		} 
	}


}