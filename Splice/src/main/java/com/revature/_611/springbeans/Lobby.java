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
	
	
}
