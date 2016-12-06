/**
 * 
 */
package com.revature._611.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature._611.dao.CardDAO;
import com.revature._611.dao.CardDAOimp;
import com.revature._611.utils.Rando;

/**
 * 2016/12/01 Game bean for Spring 1 of Splice Web Application <br>
 * Using: Serializable <br>
 * Overrides: toString(), hashCode(), equals()
 * 
 * @author Christian Gonzalez
 * @version 1.0
 */

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Player> players = new ArrayList<Player>();
	Deck deckCreatures = new Deck();
	List<Creature> wylds = new ArrayList<Creature>();
	
	public void run() {
		/*
		 * INPUT: None 
		 * OUTPUT: None
		 * DESCRIPTION: Organizes the core game loop
		 * and game setup.
		 */

		initWylds();
		initPlayers(2);
	}

	public void initWylds() {
		// TODO: Switch back to private
		/*
		 * INPUT : None
		 * OUPUT: None
		 * DESCRIPTION: Put out the first cards into
		 * the Wylds.
		 */
		CardDAO cDAO = new CardDAOimp();
		deckCreatures.setContents(cDAO.getAllCreatures());
		deckCreatures.shuffle();
		wylds = deckCreatures.deal(4);
	}

	public void initPlayers(int numPlayers) {
		// TODO: Switch back to private
		/*
		 * INPUT: None
		 * OUPUT: None
		 * DESCRIPTION: Initial player setup. Assign
		 * players' their sorcerer, determine turn order.
		 */
		CardDAO cDAO = new CardDAOimp();

		List<Sorcerer> sorcs = cDAO.getAllSorcerers();
//		List<Sorcerer> sorcs = new ArrayList<Sorcerer>();
//		sorcs.add(new Sorcerer("Xanatov"));
//		sorcs.add(new Sorcerer("Xilos"));
//		sorcs.add(new Sorcerer("Talmir"));

		for (int i = 0; i < numPlayers; i++) {
			Player newPlayer = new Player();

			// Assign sorcerers
			int n = Rando.randInt(0, (sorcs.size() - 1));
			newPlayer.setSorc(sorcs.get(n));
			sorcs.remove(n); // Remove that sorcerer so each player has a unique
								// sorcerer

			players.add(newPlayer);
		}

		// Randomize player order
		Collections.shuffle(players);
	}

	public void initTestDeck() {
		List<Creature> testContents = new ArrayList<Creature>();
		testContents.add(new Creature("Wyld Rat"));
		testContents.add(new Creature("Great Stag"));
		testContents.add(new Creature("Askyon Wolf"));
		testContents.add(new Creature("Askyon Recluse"));
		testContents.add(new Creature("Cliffside Stalker"));
		testContents.add(new Creature("Carrion Stritch"));
		testContents.add(new Creature("Cockatrice"));
		testContents.add(new Creature("Great Drake"));
		testContents.add(new Creature("Spined Wyrm"));
		testContents.add(new Creature("Frilled Wyrm"));
		
		deckCreatures.setContents(testContents);
	}

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

}
