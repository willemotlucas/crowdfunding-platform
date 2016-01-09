package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Fund;

public class FundDAOImpl extends DAOAbstract<Fund>{
	public FundDAOImpl(){
		objName = "Fund";
	}
	
	@SuppressWarnings("unchecked")
	public List<Fund> find3Last(){
		List<Fund> funds = new ArrayList<Fund>();
		
		try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" order by datePhase desc");
	    	query.setMaxResults(3);
		    funds = (List<Fund>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return funds;
		
	}
}
