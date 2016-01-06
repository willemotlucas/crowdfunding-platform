package com.utc.projetAPI01.dao;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.utc.projetAPI01.beans.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {

	@Override
	public Utilisateur find(Integer id) {
		
		Utilisateur utilisateur = null;
		
	    try
	    {
	    	Query query = session.createQuery("from Utilisateur u where u.id = :id");
	    	query.setInteger("id", id);
			Iterator utilisateurs = query.iterate();
			if(utilisateurs.hasNext())
			{
				utilisateur = (Utilisateur) utilisateurs.next();
			}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		
		return utilisateur;
		
	}

	@Override
	public Utilisateur create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		
	}

}
