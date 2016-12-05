package com.revature._611.dao;

import java.util.List;

import com.revature._611.beans.Card;
import com.revature._611.beans.Creature;
import com.revature._611.beans.Sorcerer;

public interface CardDAO {

	Sorcerer getSorcererByID(int id);
	
	List<Sorcerer> getAllSorcerers();
	
	List<Creature> getAllCreatures();
	
}
