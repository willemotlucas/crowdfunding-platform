package com.utc.projetAPI01.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;

public class ThumbDAOImpl extends DAOAbstract<Thumb>{
	public ThumbDAOImpl(){
		objName = "Thumb";
	}
	
	public int findPositiveScoreByDiscussion(int idDiscussion){
		int positiveScore = 0;
		try
	    {
	    	Query query1 = session.createQuery("select count(*) from " + objName +" where discussion = :id and score=1");
	    	query1.setInteger("id", idDiscussion);

	    	try{
				positiveScore = ((Long) query1.iterate().next()).intValue();
	    	}catch(Exception e){
	    		positiveScore = 0;
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return positiveScore;
	}
	
	public int findNegativeScoreByDiscussion(int idDiscussion){
		int negativeScore = 0;
		try
	    {
	    	Query query1 = session.createQuery("select count(*) from " + objName +" where discussion = :id and score=-1");
	    	query1.setInteger("id", idDiscussion);

	    	try{
	    		negativeScore = ((Long) query1.iterate().next()).intValue();
	    	}catch(Exception e){
	    		negativeScore = 0;
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return negativeScore;
	}
	
	public List<Thumb> findByUser(Utilisateur user){
		List<Thumb> thumbs = null;

	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where utilisateur = :id");
	    	query.setInteger("id", user.getId());
	    	thumbs = query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return thumbs;
	}
	
	public Thumb findByUserAndDiscussion(Utilisateur user, int idDiscussion){
		Thumb thumbs = null;

	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where utilisateur = :id and discussion = :idDiscussion");
	    	query.setInteger("id", user.getId());
	    	query.setInteger("idDiscussion", idDiscussion);
	    	thumbs = (Thumb) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
	    
		return thumbs;
	}
}
