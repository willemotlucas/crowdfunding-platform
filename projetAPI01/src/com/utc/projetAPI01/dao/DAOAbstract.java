package com.utc.projetAPI01.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utc.projetAPI01.beans.Utilisateur;

public abstract class DAOAbstract<T> {
	
	protected Session sessionLecture = ConnectionHibernateLecture.getInstance();
	protected Session sessionEcriture = ConnectionHibernateEcriture.getInstance();
	protected String objName;
	
	public T findById(Integer id)
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
	
	public List<T> findAll()
	{
		List<T> results = null;
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName);
	    	results = query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return results;
	}
	
	public T save(T obj)
	{
		Transaction tx = null;
		try { 
		      tx = sessionEcriture.beginTransaction();
		      sessionEcriture.save(obj);
		      sessionEcriture.flush() ;
		      tx.commit();
		    } 
		catch (HibernateException e) {
	      if (tx != null) {
	        tx.rollback();
	      }
	      throw e;
	    }
		
		return obj;
	};
		
	public void delete(T obj)
	{
		Transaction tx = null;
		try {
			tx = sessionEcriture.beginTransaction();
			sessionEcriture.delete(obj);
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null){
				tx.rollback();
			}
		}
	}

}
