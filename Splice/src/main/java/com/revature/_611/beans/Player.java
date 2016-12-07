/**
 * 2016/12/01 Player bean for Sprint 1 of Splice Web Application <br>
 * Using: Serializable <br>
 * Overrides: toString(), hashCode(), equals()
 * 
 * @author Christian Gonzalez
 * @version 1.0
 */

package com.revature._611.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
	private Sorcerer sorc;
	private List<Creature> lab = new ArrayList<Creature>();
	private int researchPool;
	
	/*
	 *  CONSTRUCTORS
	 */
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * GETTERS AND SETTERS
	 */

	public Sorcerer getSorc() {
		return sorc;
	}



	public void setSorc(Sorcerer sorc) {
		this.sorc = sorc;
	}



	public List<Creature> getLab() {
		return lab;
	}



	public void setLab(List<Creature> lab) {
		this.lab = lab;
	}
	
	

	public int getResearchPool() {
		return researchPool;
	}

	public void setResearchPool(int researchPool) {
		this.researchPool = researchPool;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lab == null) ? 0 : lab.hashCode());
		result = prime * result + ((sorc == null) ? 0 : sorc.hashCode());
		return result;
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (lab == null) {
			if (other.lab != null)
				return false;
		} else if (!lab.equals(other.lab))
			return false;
		if (sorc == null) {
			if (other.sorc != null)
				return false;
		} else if (!sorc.equals(other.sorc))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [sorc=" + sorc + ", lab=" + lab + "]";
	}
	
	
}
