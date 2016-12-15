package com.revature._611.playground;

import com.revature._611.logging.*;

<<<<<<< HEAD
public class GameTestDriver{
	public static void main(String[] args){
		LoggingUtil log = new LoggingUtil();
=======
public class GameTestDriver {
	Game theGame;
	
	public static void main(String[] args) {
		GameTestDriver me = new GameTestDriver();
		me.drive();
	}
	
	public void drive() {
		p("Driving...");
		
		
		theGame = new Game();
		p("# Initializing game...");
		theGame.initGame(2, false);
		p(theGame.toString());
		System.out.println(theGame.toJsonString());
		/* p(theGame.toString());
		p(theGame.printStatus());
		theGame.debugSetState(1, 0, 2);
		p(theGame.printStatus());
		theGame.attackCreature(theGame.getWylds().get(0).getName());
		theGame.debugSetState(2, 0, 2);
		theGame.attackCreature(theGame.getWylds().get(0).getName());
		theGame.debugSetState(3, 0, 2);
		theGame.attackCreature(theGame.getWylds().get(0).getName());
		theGame.debugSetState(4, 0, 2);
		theGame.attackCreature(theGame.getWylds().get(0).getName());
		theGame.debugSetState(5, 0, 1);
		p(theGame.printStatus());
		theGame.handleResearch(theGame.getPlayers().get(0).getLab().get(0).getName());
		p(theGame.printStatus());
		theGame.skipPhase();
		p(theGame.printStatus());
		theGame.skipPhase();
		p(theGame.printStatus());
		theGame.skipPhase();
		p(theGame.printStatus());
		theGame.skipPhase();
		p(theGame.printStatus());
		theGame.skipPhase();
		p(theGame.printStatus());
		theGame.skipPhase();
		p(theGame.printStatus());*/
		
		
		/*p(theGame.toString());
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
		theGame.debugSetState(2, 0, 2);
		p(theGame.printStatus());*/
		/*theGame.attackSorcerer(theGame.getPlayers().get(1).getSorc().getName());
		p(theGame.toString());
		p(theGame.printStatus());
		theGame.debugSetState(3, 0, 2);
		p(theGame.printStatus());
		theGame.attackSorcerer(theGame.getPlayers().get(1).getSorc().getName());
		p(theGame.toString());
		p(theGame.printStatus());
		theGame.debugSetState(4, 0, 2);
		p(theGame.printStatus());
		theGame.attackSorcerer(theGame.getPlayers().get(1).getSorc().getName());
		p(theGame.toString());
		p(theGame.printStatus());*/
>>>>>>> 42ce088ccab0bc7d1764f1e2d2afaef9df772970
		
		log.logDebug("test message");
	}
}