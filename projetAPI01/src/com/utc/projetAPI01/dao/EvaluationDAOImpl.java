package com.utc.projetAPI01.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.EvaluationScore;

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
	
	public void deleteCascade(Evaluation evaluation){
		EvaluationScoreDAOImpl evaluationScoreDAO = new EvaluationScoreDAOImpl();
		List<EvaluationScore> evaluationScores = evaluationScoreDAO.findByIdeaInEvaluation(evaluation.getId());
		Iterator<EvaluationScore> it = evaluationScores.iterator();
		while(it.hasNext()){
			EvaluationScore evaluationScore = it.next();
			evaluationScoreDAO.delete(evaluationScore);
		}
		this.delete(evaluation);
	}
}
