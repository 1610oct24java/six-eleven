package com.revature._611.beans;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Sorcerer extends Card implements Serializable {

	private static final long serialVersionUID = 2507717115716407808L;
	
	private int vitality;
	private int power;
	private int defense;
	private int speed;
	private int intelligence;
	private int woundCounters;
	
	/*----------------------------------
	 * Constructors
	 *--------------------------------*/
	
	public Sorcerer() {
		super();
	}
	
	public Sorcerer(int cardID, String imgFront, String imgBack, String imgBorder, String name, String flavor,
			boolean faceUp, int vitality, int power, int defense, int speed, int intelligence, int woundCounters) {
		
		super(cardID, imgFront, imgBack, imgBorder, name, flavor, faceUp);
		
		this.vitality = vitality;
		this.power = power;
		this.defense = defense;
		this.speed = speed;
		this.intelligence = intelligence;
		this.woundCounters = 0;
	}

	public Sorcerer(int cardID, String imgFront, String imgBack, String imgBorder, String name, String flavor,
			int vitality, int power, int defense, int speed, int intelligence, int woundCounters) {
		
		super(cardID, imgFront, imgBack, imgBorder, name, flavor);
		
		this.vitality = vitality;
		this.power = power;
		this.defense = defense;
		this.speed = speed;
		this.intelligence = intelligence;
		this.woundCounters = 0;
		
	}

	//helper function for getting successful rolls
	private int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}
	
	/*----------------------------------
	 * Sorcerer Methods
	 *--------------------------------*/
	
	//heal sorcerer by removing woundCounters
	public void heal(int hp) {
		
		this.woundCounters = this.woundCounters - hp;
		
		if (this.woundCounters < 0) {
			this.woundCounters = 0;
		}
	}
	
	//deal damage to sorcerer by adding woundCounters
	public void wound(int hp) {
		this.woundCounters = this.woundCounters + hp;
	}
	
	//check if sorcerer is dead
	public boolean isDead() {
		
		boolean dead = false;
		
		if (woundCounters >= this.vitality) {
			dead = true;
		}
		
		return dead;
	}
	
	public int roll(int stat) {
		
		int numSuccesses = 0;
		
		switch(stat) {
		
		case 1: //rolling for vit
			
			break;
			
		case 2: //rolling for pow
			
			break;
			
		case 3: //rolling for def
			
			break;
			
		case 4: //rolling for spd
			
			break;
			
		case 5: //rolling for itl
			
			break;
			
		default:
			//flag for invalid input
			//probably not best practice
			numSuccesses = -1;
			break;
		}
		
		return numSuccesses;
	}
	
	//TODO roll, upgrade
	
	/*----------------------------------
	 * Getters
	 *--------------------------------*/
	
	public int getVitality() {
		return vitality;
	}

	public int getPower() {
		return power;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpeed() {
		return speed;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWoundCounters() {
		return woundCounters;
	}

	/*----------------------------------
	 * Setters
	 *--------------------------------*/
	
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setWoundCounters(int woundCounters) {
		this.woundCounters = woundCounters;
	}

	/*----------------------------------
	 * Object Overrides
	 *--------------------------------*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + defense;
		result = prime * result + intelligence;
		result = prime * result + power;
		result = prime * result + speed;
		result = prime * result + vitality;
		result = prime * result + woundCounters;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sorcerer other = (Sorcerer) obj;
		if (defense != other.defense)
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (power != other.power)
			return false;
		if (speed != other.speed)
			return false;
		if (vitality != other.vitality)
			return false;
		if (woundCounters != other.woundCounters)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sorcerer [vitality=" + vitality + ", power=" + power + ", defense=" + defense + ", speed=" + speed
				+ ", intelligence=" + intelligence + ", woundCounters=" + woundCounters + "]";
	}
	
}