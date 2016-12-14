package com.revature._611.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Creature> contents = new ArrayList<Creature>();

	public Deck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deck(List<Creature> contents) {
		super();
		this.contents = contents;
	}

	public List<Creature> getContents() {
		return contents;
	}

	public void setContents(List<Creature> contents) {
		this.contents = contents;
	}

	public Creature deal() {
		/*
		 * INPUT: none OUTPUT: Creature DESCRIPTION: Returns the creature card
		 * at the lowest index, and removes it from the deck. If no creatures
		 * remain in the deck, returns null.
		 */
		Creature output;
		if (contents.size() > 0) {
			output = contents.get(0);
			contents.remove(0);
			return output;
		} else {
			return null;
		}
	}

	public List<Creature> deal(int n) {
		/*
		 * INPUT: Number of Cards (int) OUTPUT: List of creatures
		 * (ArrayList<Creature>) DESCRIPTION: Returns a number of crature cards
		 * specified by the given int, and removes them from the deck. If
		 * insufficient creatures remain in the deck, returns as many as
		 * possible. If no creatures remain in the deck, returns null.
		 */
		ArrayList<Creature> output = new ArrayList<Creature>();

		if (contents.size() > 0) {
			for (int i = 0; i < n; i++) {
				output.add(deal());
			}
			return output;
		} else {
			return null;
		}
	}
	
	public boolean isEmpty(){
		if (contents.size() == 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(contents);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
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
		Deck other = (Deck) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deck [contents=" + contents + "]";
	}

	public String toJsonString() {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		json.append("\n");
		json.append("\"contents\": [");
		json.append("\n");
		for (int i = 0; i < this.contents.size(); i++ ) {
			json.append(contents.get(i).toJsonString());
			if (i < contents.size() - 1) {
				json.append(",");
			}
			json.append("\n");
		}
		json.append("]}");
		
		return json.toString();
	}

}
