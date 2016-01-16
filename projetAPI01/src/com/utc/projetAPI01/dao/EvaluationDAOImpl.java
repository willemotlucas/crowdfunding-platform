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
	
	@Override
	public void delete(Evaluation evaluation){
		EvaluationScoreDAOImpl evaluationScoreDAO = new EvaluationScoreDAOImpl();
		Iterator<EvaluationScore> itEval = evaluation.getEvaluations().iterator();
		while(itEval.hasNext())
		{
			EvaluationScore evaluationScore = itEval.next();
			evaluationScoreDAO.delete(evaluationScore);
		}
		super.delete(evaluation);
	}
}
