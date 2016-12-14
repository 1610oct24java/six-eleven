package com.revature._611.springbeans;

import java.util.List;

import com.revature._611.beans.Game;

/*
* LOBBY
* Description: Container for users, messages, and Game
* 
* @author: Christian Gonzalez
* @author: Connor Anderson
*/

public class Lobby {
	String lobbyName = "default";
	String hostName;
	List<String> membersNames;
	Game myGame;
	List<String> chat;
	
	
	/*
	 * CONSTRUCTORS
	 */
	public Lobby(String lobbyName, String hostName, List<String> membersNames, Game myGame, List<String> chat) {
		super();
		this.lobbyName = lobbyName;
		this.hostName = hostName;
		this.membersNames = membersNames;
		this.myGame = myGame;
		this.chat = chat;
	}
	public Lobby() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boolean addPlaya(String playaName){
		if(!membersNames.contains(playaName)){
			membersNames.add(playaName);
			
			return true;
		}
		return false;
	}
	
	/*
	 * GETTERS AN SETTERS
	 */
	public String getLobbyName() {
		return lobbyName;
	}
	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public List<String> getMembersNames() {
		return membersNames;
	}
	public void setMembersNames(List<String> membersNames) {
		this.membersNames = membersNames;
	}
	public Game getMyGame() {
		return myGame;
	}
	public void setMyGame(Game myGame) {
		this.myGame = myGame;
	}
	public List<String> getChat() {
		return chat;
	}
	public void setChat(List<String> chat) {
		this.chat = chat;
	}
	
	/**
	 * Converts the Lobby object into a json object string
	 * 
	 * @return {
    		\"lobbyName\": \"$scope.lobbyName\",
    		hostName: $scope.onlineUser,
    		membersNames: [
    			$scope.onlineUser
    		],
    		myGame: null,
    		chat: [""]
    		}
	 */
	public String toJsonString(){
		StringBuilder jsonString = new StringBuilder();
		
		// head of json string:
		jsonString.append("{")
		.append("\"lobbyName\":\"" + lobbyName + "\",");
		jsonString.append("\"hostName\":\"" + hostName + "\",");
		jsonString.append("\"membersNames\":[");
			for (int i = 0; i < membersNames.size(); i++) {
				jsonString.append("\"" + membersNames.get(i) + "\"");
				if (i < (membersNames.size() - 1) ) {
					jsonString.append(",");
				}
			}
			jsonString.append("],");
		jsonString.append("\"game\":\"" + "null" + "\",");
		jsonString.append("\"chat\":[");
			for (int i = 0; i < chat.size(); i++) {
				jsonString.append("\"" + chat.get(i) + "\"");
				if (i < (chat.size() - 1) ) {
					jsonString.append(",");
				}
			}
			jsonString.append("],");
		jsonString.append("\"numMembers\":\"" + membersNames.size() + "\"");
		jsonString.append("}");
		
		// System.out.println("Lobby toJsonString: " + jsonString.toString());
		return jsonString.toString();
	}
	
	public String getUsersAsJson() {
		
		StringBuilder jsonString = new StringBuilder();
		
		//jsonString.append("{");
		//jsonString.append("\"membersNames\":[");
		jsonString.append("[");

		for (int i = 0; i < membersNames.size(); i++) {
			jsonString.append("\"" + membersNames.get(i) + "\"");
			if (i < (membersNames.size() - 1) ) {
				jsonString.append(",");
			}
		}
		//jsonString.append("]}");
		jsonString.append("]");
		
		return jsonString.toString();
	}
	
	
	@Override
	public String toString() {
		return "Lobby [lobbyName=" + lobbyName + ", hostName=" + hostName + ", membersNames=" + membersNames
				+ ", myGame=" + myGame + ", chat=" + chat + "]";
	}
	
}
