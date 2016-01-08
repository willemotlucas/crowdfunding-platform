package com.utc.projetAPI01.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Thumb;

public class ThumbDAOImpl extends DAOAbstract<Thumb>{
	public ThumbDAOImpl(){
		objName = "Thumb";
	}
	
	public Map<String, Integer> findScoreByIdea(int idDiscussion){
		Map<String, Integer> score = new HashMap<String, Integer>();
		int positiveScore = 0;
		int negativeScore = 0;

	    try
	    {
	    	Query query1 = sessionLecture.createQuery("select count(*) from " + objName +" where discussion = :id and score=1");
	    	query1.setInteger("id", idDiscussion);
	    	Query query2 = sessionLecture.createQuery("select count(*) from " + objName +" where discussion = :id and score=-1");
	    	query2.setInteger("id", idDiscussion);

	    	try{
				positiveScore = ((Long) query1.iterate().next()).intValue();
	    	}catch(Exception e){
	    		positiveScore = 0;
	    	}
	    	
	    	try{
	    		negativeScore = ((Long) query2.iterate().next()).intValue();
	    	}catch(Exception e){
	    		negativeScore = 0;
	    	}
	    	
	    	score.put("-1", negativeScore);
	    	score.put("+1", positiveScore);
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return score;
	}
}
