package com.utc.projetAPI01.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Idea;

public class DiscussionDAOImpl extends DAOAbstract<Discussion>{
	public DiscussionDAOImpl(){
		objName = "Discussion";
	}
	
	public Discussion findByContext(int id){
		Discussion discussion = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where context = :id");
	    	query.setInteger("id", id);
			discussion = (Discussion) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return discussion;
	}
}
