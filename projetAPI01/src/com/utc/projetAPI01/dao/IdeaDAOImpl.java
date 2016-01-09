package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Utilisateur;

public class IdeaDAOImpl extends DAOAbstract<Idea>{
	public IdeaDAOImpl()
	{
		objName = "Idea";
	}
	
	@SuppressWarnings("unchecked")
	public List<Idea> findByName(String name){
		List<Idea> ideas = new ArrayList<Idea>();
		System.out.println("received search : " + name);
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where name like :name");
	    	query.setString("name", "%"+name+"%");
			ideas = (List<Idea>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return ideas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Idea> findByApplicationField(String applicationField){
		List<Idea> ideas = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where applicationField = :applicationField");
	    	query.setString("applicationField", applicationField);
			ideas = (List<Idea>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return ideas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Idea> findByCreator(Utilisateur user){
		List<Idea> ideas = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where madeBy = :userId");
	    	query.setInteger("userId", user.getId());
			ideas = (List<Idea>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return ideas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Idea> findByLastProposed(){
		List<Idea> ideas = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" order by proposedDate desc");
	    	query.setMaxResults(3);
			ideas = (List<Idea>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return ideas;
	}	
}
