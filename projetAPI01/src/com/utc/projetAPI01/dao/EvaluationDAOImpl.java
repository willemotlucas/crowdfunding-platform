package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Evaluation;

public class EvaluationDAOImpl extends DAOAbstract<Evaluation>{
	public EvaluationDAOImpl(){
		objName = "Evaluation";
	}
	
	public Evaluation findByContext(int id){
		Evaluation evaluation = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where context = :id");
	    	query.setInteger("id", id);
			evaluation = (Evaluation) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return evaluation;
	}
}
