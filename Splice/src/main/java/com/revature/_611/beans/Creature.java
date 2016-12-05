package com.revature._611.beans;

import java.io.Serializable;

public class Creature extends Card implements Serializable {
	
	private static final long serialVersionUID = 2358819216799101453L;

	//TODO enum for card stats: vit, pow, def, spd, itl
	private int favoriteStat;
	private int dumpStat;
	private int temperment;
	private int aggressionRating;
	private int woundCounters;
	private int researchCounters;
	
}
