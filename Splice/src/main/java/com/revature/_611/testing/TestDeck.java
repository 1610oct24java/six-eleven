package com.revature._611.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature._611.beans.Creature;
import com.revature._611.beans.Deck;

public class TestDeck {
	
	List<Creature> sbjContents = new ArrayList<Creature>();
	List<Creature> empty = new ArrayList<Creature>();
	{
		sbjContents.add(new Creature("Wyld Rat"));
		sbjContents.add(new Creature("Great Stag"));
		sbjContents.add(new Creature("Askyon Wolf"));
		sbjContents.add(new Creature("Askyon Recluse"));
		sbjContents.add(new Creature("Cliffside Stalker"));
		sbjContents.add(new Creature("Carrion Stritch"));
		sbjContents.add(new Creature("Cockatrice"));
		sbjContents.add(new Creature("Great Drake"));
		sbjContents.add(new Creature("Spined Wyrm"));
		sbjContents.add(new Creature("Frilled Wyrm"));
	}
	Deck sbj = new Deck(sbjContents);
	Deck sbj2 = new Deck(empty);

	@Test
	public void testDeal() {
		/*
		 * TEST for deal method in Deck.
		 */
		p("===== Testing basic deal method =====");
		for (Creature c : sbj.getContents()){
			p(c.getName());
		}
		Creature tst1 = sbj.deal();
		Creature exp1 = new Creature ("Wyld Rat");
		assertEquals(exp1, tst1);
		Creature tst2 = sbj.deal();
		Creature exp2 = new Creature ("Great Stag");
		assertEquals(exp2, tst2);
		Creature tst3 = sbj2.deal();
		assertNull(tst3);
	}
	
	@Test
	public void testDealMany(){
		/*
		 * TEST for alternate deal method in Deck
		 */
		p("===== Test deal many variant =====");
		for (Creature c : sbj.getContents()) {
			p(c.getName());
		}
		List<Creature> tst1 = sbj.deal(3);
		List<Creature> exp1 = new ArrayList<Creature>();
			exp1.add(new Creature("Wyld Rat"));
			exp1.add(new Creature("Great Stag"));
			exp1.add(new Creature("Askyon Wolf"));
		assertEquals(exp1, tst1);
		List<Creature> test2 = sbj2.deal(2);
		assertNull(test2);
	}
	
	@Test
	public void testIsEmpty() {
		/*
		 * TEST for isEmpty method in Deck
		 */
		
		p("===== Test for isEmpty =====");
		assertFalse(sbj.isEmpty());
		assertTrue(sbj2.isEmpty());
	}
	
	@Test
	public void testShuffle() {
		/*
		 * TEST for shuffle method in Deck
		 */
		
		p("===== Test for shuffle =====");
		for (Creature c : sbj.getContents()) {
			p(c.getName());
		}
		sbj.shuffle();
		p("SHUFFLING...");
		for (Creature c : sbj.getContents()) {
			p(c.getName());
		}
	}
	
	private static void p(String s){
		System.out.println(s);
	}

}
