package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Utilisateur;

public class EvaluationScoreDAOImpl extends DAOAbstract<EvaluationScore>{
	public EvaluationScoreDAOImpl(){
		objName = "EvaluationScore";
	}
	
	@SuppressWarnings("unchecked")
	public List<EvaluationScore> findByIdeaInEvaluation(int id){
		List<EvaluationScore> evaluations = new ArrayList<EvaluationScore>();
		System.out.println("evaluation id : " + id);
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where evaluation = :id");
	    	query.setInteger("id", id);
		    evaluations = (List<EvaluationScore>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return evaluations;
	}
	
	@SuppressWarnings("unchecked")
	public List<EvaluationScore> findByUser(Utilisateur user){
		List<EvaluationScore> evaluations = new ArrayList<EvaluationScore>();
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where utilisateur = :id");
	    	query.setInteger("id", user.getId());
		    evaluations = (List<EvaluationScore>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return evaluations;
	}
}
