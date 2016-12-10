package com.revature._611.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature._611.beans.Creature;
import com.revature._611.beans.Deck;
import com.revature._611.beans.Player;
import com.revature._611.beans.Sorcerer;
import com.revature._611.dao.CardDAO;
import com.revature._611.dao.CardDAOimp;
import com.revature._611.utils.Rando;

/**
 * 2016/12/01 Game bean for Spring 1 of Splice Web Application <br>
 * Using: Serializable <br>
 * Overrides: toString(), hashCode(), equals()
 * 
 * @author Christian Gonzalez
 * @version 1.1
 */

// TODO Convert sysouts to Logging
// TODO Make custom exceptions

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Player> players = new ArrayList<Player>();
	private Deck deckCreatures = new Deck();
	private List<Creature> wylds = new ArrayList<Creature>();
	private GameState state = new GameState();
	
	
	/* ===============
	 * ACTION HANDLERS
	 * ===============
	 */
	public void skipPhase(){
		state.step(players.size());
	}
	
	public boolean attackCreature(String creatureName) {
		/*
		 * INPUT: Creature name (String)
		 * OUTPUT: Success status (boolean)
		 * DESCRIPTION: Handles an action to attack a creature
		 */
		if(state.getPhase() != 2) {
			// Ensure it is the combat phase.
			System.out.println("Attack FAILED: Invalid phase");
			return false;
		}
		Creature target = null;
		for (Creature c : wylds) {
			if (c.getName().equals(creatureName)) {
				target = c;
			}
		}
		if (target == null) {
			// Ensure creature is in wilds.
			System.out.println("Attack FAILED: Creature not in wylds");
		}
		Sorcerer mySorc = players.get(state.getTurn()).getSorc();
		
		// Damage the creature
		int wounds = calcDamagePvC(mySorc, target);
		target.wound(wounds);
		
		System.out.println(wounds + " damage dealt to the " + target.getName());
		
		if (target.isDead()) {
			System.out.println(target.getName() + " was killed!");
			// Handle creature death
			Player me = players.get(state.getTurn());
			// Remove it from the Wylds
			wylds.remove(target);
			// Replace it with a new creature
			wylds.add(deckCreatures.deal());
			// Add it to the players lab
			List<Creature> newLab = me.getLab();
			newLab.add(target);
			me.setLab(newLab);
			System.out.println(me.toString());
		} else {
			// The creature survived
			// Update creature in wylds
			int index = wylds.indexOf(target);
			wylds.set(index, target);
		}
		
		if(state.step(players.size())){
			players.get(state.getTurn()).startResearch();
		}
		
		/*state.setPhase(1);
		if (state.getTurn() < players.size() - 1){
			state.setTurn(state.getTurn() + 1);
			Player next = players.get(state.getTurn());
			next.setResearchPool(next.getSorc().getIntelligence());
			int index = players.indexOf(next);
			players.set(index, next);
		} else {
			state.setTurn(0);
			state.setRound(state.getRound() + 1);
			Player next = players.get(state.getTurn());
			next.setResearchPool(next.getSorc().getIntelligence());
			int index = players.indexOf(next);
			players.set(index, next);
		}*/
		
		return true;
	}
	
	public boolean attackSorcerer(String sorcName) {
		/*
		 * INPUT: Sorcerer name (String)
		 * OUTPUT: Success status (boolean)
		 * DESCRIPTION: Handles an action to attack a sorcerer
		 */
		if(state.getPhase() != 2) {
			// Ensure it is the combat phase.
			System.out.println("Attack FAILED: Invalid phase");
			return false;
		}
		Player targetOwner = null;
		Sorcerer target = null;
		for (Player p : players) {
			Sorcerer s = p.getSorc();
			if (s.getName().equals(sorcName)) {
				target = s;
				targetOwner = p;
			}
			
		}
		if (target == null) {
			// Ensure target is in the game
			System.out.println("Attack FAILED: Not a valid target");
		}
		Sorcerer mySorc = players.get(state.getTurn()).getSorc();
		if(mySorc == target) {
			// Ensure active player is not the target
			System.out.println("Attack FAILED: Don't attack yourself");
		}
		
		// Damage the creature
		int wounds = calcDamagePvP(mySorc, target);
		target.wound(wounds);
		
		System.out.println(wounds + " damage dealt to " + target.getName());
		
		if (target.isDead()) {
			// Handle player death
			System.out.println(target.getName() + " was killed!");
			// Remove player from game
			players.remove(targetOwner);
		} else {
			// The creature survived
			// Update sorcerer
			int index = players.indexOf(targetOwner);
			targetOwner.setSorc(target);
			players.set(index, targetOwner);
		}
		
		if(state.step(players.size())){
			players.get(state.getTurn()).startResearch();
		}
		
		/*state.setPhase(1);
		if (state.getTurn() < players.size() - 1){
			state.setTurn(state.getTurn() + 1);
		} else {
			state.setTurn(0);
			state.setRound(state.getRound() + 1);
		}*/
		
		return true;
	}
	
	public boolean handleResearch(String creatureName) {
		/*
		 * INPUT: Creature Name (String)
		 * OUTPUT: Status flag (boolean)
		 * DESCRIPTION: Handles assigning research points to a creature,
		 * including error checking.
		 */
		if ( state.getPhase() != 1 ) {
			// Ensure it is actually the research phase
			System.out.println("Research FAILED: Invalid phase");
			return false;
		}
		
		// Get the instance of the target creature
		Creature target = null;
		Player me = players.get(state.getTurn());
		for (Creature c : me.getLab()) {
			if (c.getName().equals(creatureName)) {
				target = c;
			}
		}
		if (target == null) {
			// Ensure creature is in the player's lab
			System.out.println("Research FAILED: " + creatureName + " not in laboratory");
			return false;
		}
		
		if (me.getResearchPool() > 0) {
			// Assign the research points
			target.research(1);
			me.setResearchPool(me.getResearchPool() - 1);
		} else {
			// Abandon the research
			System.out.println("Research FAILED: Insufficient counters");
			return false;
		}
		System.out.println(players.get(state.getTurn()).toString());
		return true;
	}
	
	public boolean handleHeal(String sorcName) {		
		if (state.getPhase() != 1 ) {
			// Ensure it is, in fact, the research phase.
			System.out.println("Heal FAILED: Invalid phase");
			return false;
		}
		if (players.get(state.getTurn()).getSorc().getWoundCounters() <= 0) {
			// Ensure the target sorcerer is wounded.
			System.out.println("Heal FAILED: Target not wounded");
			return false;
		}
		String currSorcName = players.get(state.getTurn()).getSorc().getName();
		if ( !currSorcName.equals(sorcName)) {
			// Ensure the current player controls that sorcerer.
			System.out.println("Heal FAILED: Invalid target");
			return false;
		}
		if (players.get(state.getTurn()).getResearchPool() < 1) {
			// Ensure the current player has sufficient research counters to spend;
			System.out.println("Heal FAILED: Insufficient research counters");
			return false;
		}
		Player me = players.get(state.getTurn());
		Sorcerer mySorc = me.getSorc();
		me.setResearchPool(me.getResearchPool() - 1);
		mySorc.setWoundCounters(mySorc.getWoundCounters() - 1);
		
		return true;
	}
	
	/* ======================
	 * ROLLS AND CALCULATIONS
	 * ======================
	 */
	
	private int calcDamagePvC(Sorcerer attacker, Creature defender) {
		/*
		 * INPUT: Attacker (Sorcerer), Defender (Creature)
		 * OUTPUT: Wounds dealt (int)
		 * DESCRIPTION: Calculates the result of an attack on a creature.
		 */
		int output = 0;
		
		int atkSuccess = attacker.roll(2);
		int defSuccess = defender.getDefense();
		
		output = atkSuccess - defSuccess;
		if (output < 0 ) {
			// Set floor to 0
			output = 0;
		}
		
		return output;
	}
	
	private int calcDamagePvP(Sorcerer attacker, Sorcerer defender) {
		/*
		 * INPUT: Attacker (Sorcerer), Defender (Creature)
		 * OUTPUT: Wounds dealt (int)
		 * DESCRIPTION: Calculates the result of an attack on a creature.
		 */
		int output = 0;
		
		int atkSuccess = attacker.roll(2);
		int defSuccess = defender.roll(3);
		
		output = atkSuccess - defSuccess;
		if (output < 0 ) {
			// Set floor to 0
			output = 0;
		}
		
		return output;
	}
	
	/* ===============
	 * SETUP FUNCTIONS
	 * ===============
	 */
	
	public void initGame(int numPlayers, boolean debugFlag){
		initWylds(debugFlag);
		initPlayers(numPlayers, debugFlag);
	}
	
	private void initWylds(boolean debugFlag) {
		/*
		 * INPUT : Debug Mode Flag (boolean)
		 * OUPUT: None
		 * DESCRIPTION: Put out the first cards into
		 * the Wylds.
		 */
		
		CardDAO cDAO = new CardDAOimp();
		deckCreatures.setContents(cDAO.getAllCreatures());
		if (!debugFlag) {
			deckCreatures.shuffle();
		}
		wylds = deckCreatures.deal(4);
	}
	
	private void initPlayers(int numPlayers, boolean debugFlag) {
		/*
		 * INPUT: Number of Players (int), Debug Mode Flag (boolean)
		 * OUPUT: None
		 * DESCRIPTION: Initial player setup. Assign
		 * players' their sorcerer, determine turn order.
		 */
		CardDAO cDAO = new CardDAOimp();

		List<Sorcerer> sorcs = cDAO.getAllSorcerers();
		
		int n = -1;
		for (int i = 0; i < numPlayers; i++) {
			Player newPlayer = new Player();

			// Assign sorcerers
			if(!debugFlag) {
				n = Rando.randInt(0, (sorcs.size() - 1));
			} else {
				n++;
			}
			newPlayer.setSorc(sorcs.get(n));
			sorcs.remove(n); // Remove that sorcerer so each player has a unique
								// sorcerer

			players.add(newPlayer);
		}

		// Randomize player order
		Collections.shuffle(players);
	}
	
	/* ===================
	 * GETTERS AND SETTERS
	 * ===================
	 */
	
	public List<Creature> getWylds(){
		return wylds;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String output = "Game [players=";
		for (Player p : players) {
			output = output + p.getSorc().getName() + ", ";
		}
		output = output + "], wylds=";
		for (Creature c : wylds) {
			output = output + c.getName() + ", ";
		}
		output = output + "]";

		return output;
	}
	
	/*  ====================
	 *  DEBUG & TESTING ONLY
	 *  ====================
	 */ 
	public void debugSetState(int round, int turn, int phase) {
		state.setPhase(phase);
		state.setTurn(turn);
		state.setRound(round);
	}
	
	public String printStatus() {
		/*
		 * INPUT: None
		 * OUTPUT: Status Report (String)
		 * DESCRIPTION: Reports the current phase, turn, and round
		 */
		String output = ""
				+ "Round: " + state.getRound() + ", "
				+ "Turn: " + players.get(state.getTurn()).getSorc().getName() + ", "
				+ "Phase: ";
		if (state.getPhase() == 1) {
			output += "Research";
		} else if (state.getPhase() == 2){
			output += "Combat";
		} else {
			output += "INVALID";
		}
		
		return output;
	}
	

}
