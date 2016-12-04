package com.revature._611.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 3-DEC-2016
 * Card abstract class for use in Splice
 * 
 * @author Matt Pierzynski (with some help from eclipse auto-generation
 * @version 1.0
 */

@Entity
@Table(name="card")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Card implements Serializable {

	private static final long serialVersionUID = 7058798466007079496L;
	
	@Id
	@Column(name="card_id")
	private int cardID;
	
	@Column(name="img_front")
	private String imgFront;
	
	@Column(name="img_back")
	private String imgBack;
	
	@Column(name="img_border")
	private String imgBorder;
	
	@Column(name="card_name")
	private String name;
	
	@Column(name="card_flavor")
	private String flavor;
	
	private boolean faceUp;
	
	public Card() {
		super();
	}

	public Card(int cardID, String imgFront, String imgBack, String imgBorder, String name, String flavor,
			boolean faceUp) {
		super();
		this.cardID = cardID;
		this.imgFront = imgFront;
		this.imgBack = imgBack;
		this.imgBorder = imgBorder;
		this.name = name;
		this.flavor = flavor;
		this.faceUp = faceUp;
	}

	public Card(int cardID, String imgFront, String imgBack, String imgBorder, String name, String flavor) {
		super();
		this.cardID = cardID;
		this.imgFront = imgFront;
		this.imgBack = imgBack;
		this.imgBorder = imgBorder;
		this.name = name;
		this.flavor = flavor;
		this.faceUp = false;
	}

	public int getCardID() {
		return cardID;
	}

	public String getImgFront() {
		return imgFront;
	}

	public String getImgBack() {
		return imgBack;
	}

	public String getImgBorder() {
		return imgBorder;
	}

	public String getName() {
		return name;
	}

	public String getFlavor() {
		return flavor;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public void setImgFront(String imgFront) {
		this.imgFront = imgFront;
	}

	public void setImgBack(String imgBack) {
		this.imgBack = imgBack;
	}

	public void setImgBorder(String imgBorder) {
		this.imgBorder = imgBorder;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	
	public void flip() {
		this.faceUp = !this.faceUp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardID;
		result = prime * result + (faceUp ? 1231 : 1237);
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + ((imgBack == null) ? 0 : imgBack.hashCode());
		result = prime * result + ((imgBorder == null) ? 0 : imgBorder.hashCode());
		result = prime * result + ((imgFront == null) ? 0 : imgFront.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Card other = (Card) obj;
		if (cardID != other.cardID)
			return false;
		if (faceUp != other.faceUp)
			return false;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (imgBack == null) {
			if (other.imgBack != null)
				return false;
		} else if (!imgBack.equals(other.imgBack))
			return false;
		if (imgBorder == null) {
			if (other.imgBorder != null)
				return false;
		} else if (!imgBorder.equals(other.imgBorder))
			return false;
		if (imgFront == null) {
			if (other.imgFront != null)
				return false;
		} else if (!imgFront.equals(other.imgFront))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [cardID=" + cardID + ", imgFront=" + imgFront + ", imgBack=" + imgBack + ", imgBorder=" + imgBorder
				+ ", name=" + name + ", flavor=" + flavor + ", faceUp=" + faceUp + "]";
	}
	
}
