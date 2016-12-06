/**
 * 
 */
package com.revature._611.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 2016/12/01 Game bean for Spring 1 of Splice Web Application <br>
 * Using: Serializable <br>
 * Overrides: toString(), hashCode(), equals()
 * 
 * @author Christian Gonzalez
 * @version 1.0
 */

public class Game implements Serializable {
	List<Player> players = new ArrayList<Player>();
	Deck deckCreatures = new Deck();
	List<Creature> wylds = new ArrayList<Creature>();
	
	
}
