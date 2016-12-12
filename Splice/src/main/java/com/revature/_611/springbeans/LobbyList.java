package com.revature._611.springbeans;

import java.util.ArrayList;
import java.util.List;

/*
 * LOBBY LIST
 * Description: Container class for all the lobbies
 * 
 * @author: Christian Gonzalez
 * @author: Connor Anderson
 */

public class LobbyList {
	private List<Lobby> lobbiesList = new ArrayList<Lobby>();

	public List<Lobby> getLobbiesList() {
		return lobbiesList;
	}

	public void setLobbiesList(List<Lobby> lobbiesList) {
		this.lobbiesList = lobbiesList;
	}
	
	
}
