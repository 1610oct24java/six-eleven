package com.revature._611.playground;

import com.revature._611.beans.Game;

public class GameTestDriver {
	Game theGame;
	
	public static void main(String[] args) {
		GameTestDriver me = new GameTestDriver();
		me.drive();
	}
	
	public void drive() {
		p("Driving...");
		theGame = new Game();
		theGame.initTestDeck();
		p(theGame.toString());
		p("# Initializing players...");
		theGame.initPlayers(2);
		p(theGame.toString());
		p("# Initializing wylds...");
		theGame.initWylds();
		p(theGame.toString());
	}
	
	public void p (String s) {
		System.out.println(s);
	}
}
