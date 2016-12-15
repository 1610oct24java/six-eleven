package com.revature._611.controllers;

import com.revature._611.beans.Message;
import com.revature._611.springbeans.Lobby;
import com.revature._611.springbeans.LobbyList;
import com.revature._611.springbeans.LoggedInUsersList;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Aspect
@Controller
public class LobbyController {

	@Autowired
	LoggedInUsersList usersOnline;
	@Autowired
	LobbyList myLobbies;

	@RequestMapping(value="/getOnlineUsers", method = RequestMethod.GET)	
	public @ResponseBody String getOnlineUsers()  {
		
		List<String> usersList = usersOnline.getUsersList();
		
		String jsonString = usersOnline.toJsonString();
		
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
	
	@RequestMapping(value =  "/lobbyJoin", method = RequestMethod.POST)
	public @ResponseBody String joinLobby (@RequestBody String lobbyAndUser) {
		String jsonString = "{}";
		String[] strToSplit = lobbyAndUser.split("\\|");
		String lobbyName = strToSplit[0];
		String userName = strToSplit[1];

		// TODO Make sure you're not already in there
		for (Lobby l : myLobbies.getLobbiesList()) {
			System.out.println("Lobbyinlist: " + l.getLobbyName() + "\n joiningLobby: " + lobbyName);
			if (l.getLobbyName().equals(lobbyName)) {				
				//if (!l.getMembersNames().contains(l.getHostName())) {
				l.addPlaya(userName);
				jsonString = l.toJsonString();
				//}
			}
		}
		
		System.out.println("JSON String yo:" + jsonString);
		return jsonString;
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