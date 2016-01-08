package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Thumb;

public class ThumbDAOImpl extends DAOAbstract<Thumb>{
	public ThumbDAOImpl(){
		objName = "Thumb";
	}
	
	public int findScoreByIdea(int idDiscussion){
		int score = 0;
		
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where discussion = :id");
	    	query.setInteger("id", idDiscussion);
	    	try{
				score = query.getMaxResults();
	    	}catch(Exception e){
	    		score = 0;
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return score;
	}
}
