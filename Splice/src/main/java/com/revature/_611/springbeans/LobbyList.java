package com.revature._611.springbeans;

import java.util.ArrayList;
import java.util.List;

/*
 * LOBBY LIST
 * Description: Container class for all the Lobbies
 * 
 * @author: Christian Gonzalez
 * @author: Connor Anderson
 */

public class LobbyList {
	private List<Lobby> lobbiesList = new ArrayList<Lobby>();

	public List<Lobby> getLobbiesList() {
		return lobbiesList;
	}
	
	public void addLobby (Lobby newLobby) {
		lobbiesList.add(newLobby);
	}

	public void setLobbiesList(List<Lobby> lobbiesList) {
		this.lobbiesList = lobbiesList;
	}
	
	public Lobby getLobbyByName(String name) {
		for (Lobby l : lobbiesList) {
			if(l.getLobbyName().equals(name)) {
				return l;
			}
		}
		
		return null;
	}
	
	public String toJsonString(){
		StringBuilder jsonString = new StringBuilder();
		
		// head of json string:
		jsonString.append("{\"lobbies\":[");
		
		// build players into the players JSON array:
		for (int i=0; i < lobbiesList.size(); i++){
			// jsonString.append("{\"lobby\":\" ");
			jsonString.append(lobbiesList.get(i).toJsonString());
			//jsonString.append( "\"}");
			// add a comma if there is an extra player
			if (i < lobbiesList.size()-1){
				jsonString.append(",");
			}
		}
		// Add the end of the JSON string
		jsonString.append("]}");
		
		// Check the JSON here...
		// System.out.println("**Lobby JSON list: " + jsonString.toString());
		return jsonString.toString();
	}
}
