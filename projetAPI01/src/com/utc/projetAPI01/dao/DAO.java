package com.utc.projetAPI01.dao;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utc.projetAPI01.beans.Utilisateur;

public abstract class DAO<T> {
	
	protected Session sessionLecture = ConnectionHibernateLecture.getInstance();
	protected Session sessionEcriture = ConnectionHibernateEcriture.getInstance();
	protected String objName;
	
	public T find(Integer id)
	{
		T obj = null;
		
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where id = :id");
	    	query.setInteger("id", id);
			Iterator objects = query.iterate();
			if(objects.hasNext())
			{
				obj = (T) objects.next();
			}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		
		return obj;
		
	}
	
	public T create(T obj)
	{
		Transaction tx = null;
		try { 
		      tx = sessionEcriture.beginTransaction(); ;
		      sessionEcriture.save(obj);
		      sessionEcriture.flush() ;
		      tx.commit();
		    } 
		catch (Exception e) {
	      if (tx != null) {
	        tx.rollback();
	      }
	      throw e;
	    }
		
		return obj;
	};
	
	public abstract T update(T obj);
	
	public abstract void delete(T obj);

}
