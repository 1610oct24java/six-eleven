package com.revature._611.playground;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.revature._611.beans.Creature;
import com.revature._611.beans.Sorcerer;
import com.revature._611.beans.User;
import com.revature._611.dao.CardDAOimp;
import com.revature._611.dao.UserDAOImpl;

public class TestDriver {

	public static int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}
	
	public static void main(String[] args) {
		CardDAOimp carddao = new CardDAOimp();
		
	}

}
