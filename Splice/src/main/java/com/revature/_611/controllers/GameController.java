package com.revature._611.controllers;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature._611.beans.CommandPacket;
import com.revature._611.springbeans.Game;
import com.revature._611.springbeans.Lobby;
import com.revature._611.springbeans.LobbyList;


@Aspect
@Controller
public class GameController {
	
	@Autowired
	LobbyList myLobbies;

	@RequestMapping(value="/getGame", method = RequestMethod.POST)	
	public @ResponseBody String getGameState(@RequestBody String lobbyName) {	
		Game game;
		
		// Get lobby
		Lobby l = myLobbies.getLobbyByName(lobbyName);
		
		// Check if there already is a game
		if ( l.getMyGame() == null ) {
			// If not, make it
			game = new Game();
			game.initGame(2, false);
			l.setMyGame(game);
		} else {
			// Else, get it
			game = l.getMyGame();
		}
		
		return game.toJsonString(); 
	}
	
	@RequestMapping(value="/handleCommand", method = RequestMethod.POST)
	public @ResponseBody String doCommand(@RequestBody CommandPacket commandIn) {
		System.out.println(commandIn.toString());
		
		Lobby myLobby = myLobbies.getLobbyByName(commandIn.getLobbyName());
		Game myGame = myLobby.getMyGame();
		
		switch (commandIn.getCommand()) {
		case "attack":
			System.out.println("Attack: " + commandIn.getData() + ", From: " + commandIn.getFrom());
			myGame.attackCreature(commandIn.getData());
			break;
		case "research":
			System.out.println("Research: " + commandIn.getData() + ", From: " + commandIn.getFrom());
			myGame.handleResearch(commandIn.getData());
			break;
		case "skip":
			System.out.println("Skip");
			myGame.skipPhase();
			break;
		default:
			System.out.println("Ya dun goofed your command");
			break;
		}
		
		return myGame.toJsonString();
	}
}
