package com.revature._611.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature._611.beans.Card;
import com.revature._611.beans.Creature;
import com.revature._611.beans.Sorcerer;
import com.revature._611.utils.HibernateUtil;

/**
 * 4-DEC-2016
 * Card DAO implementation
 * 
 * @author Matt Pierzynski
 * @version 1.0
 */

public class CardDAOimp implements CardDAO {

	private HibernateUtil hu;
	
	public CardDAOimp() {
		super();
		hu = new HibernateUtil();
	}
	
	@Override
	public Card getCard(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sorcerer> getSorcerers() {
		
		Session sesh = hu.getSession();
		
		String hql = "FROM com.revature._611.beans.Sorcerer";
		
		Query query = sesh.createQuery(hql);
		
		List sorcerers = query.list();
		
		sesh.close();
		
		return sorcerers;
	}

	@Override
	public List<Creature> getCreatures() {
		// TODO Auto-generated method stub
		return null;
	}

}
