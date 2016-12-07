package com.revature._611.playground;

import com.revature._611.game.Game;

public class GameTestDriver {
	Game theGame;
	
	public static void main(String[] args) {
		GameTestDriver me = new GameTestDriver();
		me.drive();
	}
	
	public void drive() {
		p("Driving...");
		theGame = new Game();
		p(theGame.toString());
		p("# Initializing players...");
		theGame.initPlayers(2);
		p(theGame.toString());
		p("# Initializing wylds...");
		theGame.initWylds();
		p(theGame.toString());
		p(theGame.printStatus());
		theGame.debugSetState(1, 0, 2);
		p(theGame.printStatus());
		theGame.attackCreature(theGame.getWylds().get(2).getName());
		p(theGame.toString());
		p(theGame.printStatus());
		theGame.attackCreature(theGame.getWylds().get(2).getName());
		theGame.debugSetState(1, 1, 2);
		p(theGame.toString());
		p(theGame.printStatus());
		theGame.attackCreature(theGame.getWylds().get(2).getName());
		p(theGame.toString());
		p(theGame.printStatus());
		theGame.attackCreature(theGame.getWylds().get(2).getName());
		p(theGame.toString());
		p(theGame.printStatus());
	}
	
	public void p (String s) {
		System.out.println(s);
	}
}
