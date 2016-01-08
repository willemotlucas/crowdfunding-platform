package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Redaction;

public class RedactionDAOImpl extends DAOAbstract<Redaction>{
	public RedactionDAOImpl(){
		objName = "Redaction";
	}
	
	public Redaction findByContext(int id){
		Redaction redaction = null;
		
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where context = :id");
	    	query.setInteger("id", id);
			redaction = (Redaction) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return redaction;
	}
}
