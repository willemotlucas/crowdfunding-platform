package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.MakeFund;
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
	    	Query query = session.createQuery("from " + objName +" where evaluation = :id");
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
	    	Query query = session.createQuery("from " + objName +" where utilisateur = :id");
	    	query.setInteger("id", user.getId());
		    evaluations = (List<EvaluationScore>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return evaluations;
	}
	
	public EvaluationScore findByUserAndEvaluation(Utilisateur user, int idEvaluation){
		EvaluationScore evaluationScore = null;
		
		try
	    {
	    	Query query = session.createQuery("from " + objName +" m where utilisateur = :idUser and evaluation = :idEvaluation");
	    	query.setInteger("idUser", user.getId());
	    	query.setInteger("idEvaluation", idEvaluation);
	    	evaluationScore = (EvaluationScore) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		
		return evaluationScore;
	}
	
	@Override
	public void delete(EvaluationScore evaluationScore)
	{
		evaluationScore.getEvaluation().getEvaluations().remove(evaluationScore);
		evaluationScore.getUtilisateur().getScores().remove(evaluationScore);
		super.delete(evaluationScore);
	}
	
	@Override
	public EvaluationScore save(EvaluationScore evaluationScore)
	{
		evaluationScore.getEvaluation().getEvaluations().add(evaluationScore);
		evaluationScore.getUtilisateur().getScores().add(evaluationScore);
		super.save(evaluationScore);
		return evaluationScore;
	}
}
