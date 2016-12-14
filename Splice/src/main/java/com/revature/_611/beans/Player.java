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
	private int researchPool = 5;
	private int killCount = 0;
	private List<Creature> lab = new ArrayList<Creature>();
	
	public String toJsonString() {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		json.append("\"sorc\": " + sorc.toJsonString() + ",");
		json.append("\n");
		json.append("\"researchPool\": \"" + researchPool + "\",");
		json.append("\n");
		json.append("\"killCount\": \"" + killCount + "\",");
		json.append("\n");
		json.append("\"lab\": [");
		for (int i = 0; i < lab.size(); i++ ) {
			json.append(lab.get(i).toJsonString());
			if (i < lab.size() - 1){
				json.append(",");
			}
		}
		json.append("]}");
		
		return json.toString();
	}
	
	/*
	 *  CONSTRUCTORS
	 */
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
		//researchPool = sorc.getIntelligence();
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

	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	

	@Override
	public String toString() {
		return "Player [sorc=" + sorc + ", researchPool=" + researchPool + ", killCount=" + killCount + ", lab=" + lab
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + killCount;
		result = prime * result + ((lab == null) ? 0 : lab.hashCode());
		result = prime * result + researchPool;
		result = prime * result + ((sorc == null) ? 0 : sorc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (killCount != other.killCount)
			return false;
		if (lab == null) {
			if (other.lab != null)
				return false;
		} else if (!lab.equals(other.lab))
			return false;
		if (researchPool != other.researchPool)
			return false;
		if (sorc == null) {
			if (other.sorc != null)
				return false;
		} else if (!sorc.equals(other.sorc))
			return false;
		return true;
	}

	public void startResearch() {
		// TODO Auto-generated method stub
		this.researchPool = this.sorc.getIntelligence();
	}
	
	
}
