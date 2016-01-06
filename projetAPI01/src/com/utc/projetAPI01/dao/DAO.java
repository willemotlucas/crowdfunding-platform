package com.utc.projetAPI01.dao;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.utc.projetAPI01.beans.Utilisateur;

public abstract class DAO<T> {
	
	public Session session = ConnectionHibernate.getInstance();
	protected String objName;
	
	public T find(Integer id)
	{
		T obj = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where id = :id");
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
	
	public abstract T create(T obj);
	
	public abstract T update(T obj);
	
	public abstract void delete(T obj);

}
