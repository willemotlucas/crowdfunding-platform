package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.utc.projetAPI01.beans.Comments;
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
	public List<Idea> findByPhase(String phase){
		List<Idea> ideas = new ArrayList<Idea>();
		System.out.println("received search : " + phase);
	    try
	    {
	    	Query query = session.createQuery("select idea from PhaseContext where currentPhase like :phase");
	    	query.setString("phase", "%"+phase+"%");
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
	
	public int findNbIdeaByUser(Utilisateur user){
		int nbIdeas = 0;
		
	    try
	    {
	    	Query query = session.createQuery("select count(*) from " + objName +" where madeBy = :userId");
	    	query.setInteger("userId", user.getId());
	    	try{
	    		nbIdeas = ((Long) query.iterate().next()).intValue();
	    	}catch(Exception e){
	    		nbIdeas = 0;
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return nbIdeas;
	}
	
	public Idea findByMaxComments(){
		Idea idea = null;
		
	    try
	    {
	    	String sql = "SELECT idea FROM ( SELECT idea, count(*) as nbComments FROM comments GROUP BY idea ORDER BY nbComments DESC) res";
	    	Integer idIdea = (Integer) session.createSQLQuery(sql).setMaxResults(1).uniqueResult();
	    	idea = this.findById(idIdea);
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return idea;
	}
	
	@Override
	public void delete(Idea idea)
	{
		PhaseContextDAOImpl phaseContextDao = new PhaseContextDAOImpl();
		PhaseContext phaseContext = phaseContextDao.findByIdea(idea.getId());
		
		if(phaseContext != null)
		{
			phaseContextDao.delete(phaseContext);
		}
		
		CommentsDAOImpl commentsDao = new CommentsDAOImpl();
		Iterator<Comments> itCo = idea.getComments().iterator();
		while(itCo.hasNext())
		{
			Comments comment = itCo.next();
			commentsDao.delete(comment);
		}
		
		super.delete(idea);
	}
}
