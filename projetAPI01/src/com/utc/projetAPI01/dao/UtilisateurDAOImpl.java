package com.utc.projetAPI01.dao;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.utc.projetAPI01.beans.Utilisateur;

public class UtilisateurDAOImpl extends DAOAbstract<Utilisateur> {
	
	public UtilisateurDAOImpl()
	{
		objName = "Utilisateur";
	}
	
	public Utilisateur findByEmail(String email) {
		
		Utilisateur user = null;
		
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where email = :email");
	    	query.setString("email", email);
			user = (Utilisateur) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return user;
	}

}
