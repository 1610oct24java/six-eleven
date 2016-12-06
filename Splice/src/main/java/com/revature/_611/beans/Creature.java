package com.revature._611.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 5-DEC-2016
 * Card abstract class for use in Splice
 * 
 * @author Matt Pierzynski
 * @version 1.0
 * 
 * TODO add creature functionality
 */

@Entity
@Table(name="creature")
@PrimaryKeyJoinColumn(name="card_id")
public class Creature extends Card implements Serializable {
	
	private static final long serialVersionUID = 2358819216799101453L;

	@Column(name="vit")
	private int vitality;
	
	@Column(name="pow")
	private int power;
	
	@Column(name="def")
	private int defense;
	
	@Column(name="spd")
	private int speed;
	
	@Column(name="itl")
	private int intelligence;
	
	@Column(name="favored_stat")
	private int favoriteStat;
	
	@Column(name="dump_stat")
	private int dumpStat;
	
	@Column(name="temperment")
	private int temperment;
	
	@Column(name="aggr_rating")
	private int aggressionRating;
	
	@Transient
	private int woundCounters;
	
	@Transient
	private int researchCounters;

	/*----------------------------------
	 * Constructors
	 *--------------------------------*/
	
	public Creature() {
		super();
		this.woundCounters = 0;
		this.researchCounters = 0;
	}
	
	public Creature(String _name){
		super();
		this.name = _name;
		this.woundCounters = 0;
		this.researchCounters = 0;
	}

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

	public int getFavoriteStat() {
		return favoriteStat;
	}

	public int getDumpStat() {
		return dumpStat;
	}

	public int getTemperment() {
		return temperment;
	}

	public int getAggressionRating() {
		return aggressionRating;
	}

	public int getWoundCounters() {
		return woundCounters;
	}

	public int getResearchCounters() {
		return researchCounters;
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

	public void setFavoriteStat(int favoriteStat) {
		this.favoriteStat = favoriteStat;
	}

	public void setDumpStat(int dumpStat) {
		this.dumpStat = dumpStat;
	}

	public void setTemperment(int temperment) {
		this.temperment = temperment;
	}

	public void setAggressionRating(int aggressionRating) {
		this.aggressionRating = aggressionRating;
	}

	public void setWoundCounters(int woundCounters) {
		this.woundCounters = woundCounters;
	}

	public void setResearchCounters(int researchCounters) {
		this.researchCounters = researchCounters;
	}

	/*----------------------------------
	 * Object Overrides
	 *--------------------------------*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + aggressionRating;
		result = prime * result + defense;
		result = prime * result + dumpStat;
		result = prime * result + favoriteStat;
		result = prime * result + intelligence;
		result = prime * result + power;
		result = prime * result + researchCounters;
		result = prime * result + speed;
		result = prime * result + temperment;
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
		Creature other = (Creature) obj;
		if (aggressionRating != other.aggressionRating)
			return false;
		if (defense != other.defense)
			return false;
		if (dumpStat != other.dumpStat)
			return false;
		if (favoriteStat != other.favoriteStat)
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (power != other.power)
			return false;
		if (researchCounters != other.researchCounters)
			return false;
		if (speed != other.speed)
			return false;
		if (temperment != other.temperment)
			return false;
		if (vitality != other.vitality)
			return false;
		if (woundCounters != other.woundCounters)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Creature [vitality=" + vitality + ", power=" + power + ", defense=" + defense + ", speed=" + speed
				+ ", intelligence=" + intelligence + ", favoriteStat=" + favoriteStat + ", dumpStat=" + dumpStat
				+ ", temperment=" + temperment + ", aggressionRating=" + aggressionRating + ", woundCounters="
				+ woundCounters + ", researchCounters=" + researchCounters + "]";
	}
	
	
	
}
