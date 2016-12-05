package com.revature._611.dao;

import java.util.List;

import com.revature._611.beans.Card;

public interface CardDAO {

	Card getCard(int id);
	
	List<Card> getAllCards();
	
	List<Card> getSorcerers();
	
	List<Card> getCreatures();
	
}
