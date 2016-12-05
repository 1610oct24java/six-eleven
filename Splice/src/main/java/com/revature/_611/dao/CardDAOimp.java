package com.revature._611.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

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

	private HibernateUtil hu = new HibernateUtil();
	
	public CardDAOimp() {
		super();
	}

	@Override
	public Sorcerer getSorcererByID(int id) {
		
		Sorcerer sorcerer = null;
		
		Session sesh;
		
		sesh = hu.getSession();
		
		sorcerer = (Sorcerer) sesh.get(Sorcerer.class, id);
		
		sesh.close();
		
		return sorcerer;
	}

	@Override
	public List<Sorcerer> getAllSorcerers() {
		
		Session sesh;
		
		sesh = hu.getSession();
		
		String hql = "FROM Sorcerer";
		
		Query query = sesh.createQuery(hql);
		
		List<Sorcerer> sorcerers = query.list();
		
		sesh.close();
		
		return sorcerers;
	}

	@Override
	public List<Creature> getAllCreatures() {
		Session sesh;
		
		sesh = hu.getSession();
		
		String hql = "FROM Creature";
		
		Query query = sesh.createQuery(hql);
		
		List<Creature> creatures = query.list();
		
		sesh.close();
		
		return creatures;
	}
	


}
