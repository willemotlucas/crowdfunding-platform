package com.utc.projetAPI01.dao;

import com.utc.projetAPI01.beans.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Idea;

public class PhaseContextDAOImpl extends DAOAbstract<PhaseContext>{
	public PhaseContextDAOImpl()
	{
		objName = "PhaseContext";
	}

	@SuppressWarnings({ "unchecked", "null" })
	public List<Idea> findIdeaByPhase(String phase){
		List<PhaseContext> contexts = null;
		List<Idea> ideas = new ArrayList<Idea>();
		System.out.println("phase : " + phase);
	    try{
	    	Query query = session.createQuery("from " + objName +" where currentPhase = :phase");
	    	query.setString("phase", phase);
			contexts = (List<PhaseContext>) query.list();
			for(Iterator<PhaseContext> it = contexts.iterator(); it.hasNext();){
				PhaseContext context = it.next();
				System.out.println("context id : " + context.getId());
				Idea idea = context.getIdea();
				ideas.add(idea);
			}
	    }catch(HibernateException e){
	    	e.printStackTrace();
	    }
		return ideas;
	}
	
	public List<Idea> findIdeaInProposal(){
		return this.findIdeaByPhase("proposal");
	}
	
	public List<Idea> findIdeaInDiscussion(){
		return this.findIdeaByPhase("discussion");
	}
	
	public List<Idea> findIdeaInRedaction(){
		return this.findIdeaByPhase("redaction");
	}
	
	public List<Idea> findIdeaInEvaluation(){
		return this.findIdeaByPhase("evaluation");
	}
	
	public List<Idea> findIdeaInFunding(){
		return this.findIdeaByPhase("fund");
	}
	
	public PhaseContext findByIdea(int id){
		PhaseContext context = null;
	    try{
	    	Query query = session.createQuery("from " + objName +" where idea = :id");
	    	query.setInteger("id", id);
			context = (PhaseContext) query.uniqueResult();
	    }catch(HibernateException e){
	    	e.printStackTrace();
	    }
		return context;
	}
	
	@Override
	public void delete(PhaseContext phaseContext)
	{
		ProposalDAOImpl proposalDao = new ProposalDAOImpl();
		Proposal proposal = proposalDao.findByContext(phaseContext.getId());
		if(proposal != null)
		{
			proposalDao.delete(proposal);
		}
		
		DiscussionDAOImpl discussionDao = new DiscussionDAOImpl();
		Discussion discussion = discussionDao.findByContext(phaseContext.getId());
		if(discussion != null)
		{
			discussionDao.delete(discussion);
		}
		
		RedactionDAOImpl redactionDao = new RedactionDAOImpl();
		Redaction redaction = redactionDao.findByContext(phaseContext.getId());
		if(redaction != null)
		{
			redactionDao.delete(redaction);
		}
		
		EvaluationDAOImpl evaluationDao = new EvaluationDAOImpl();
		Evaluation evaluation = evaluationDao.findByContext(phaseContext.getId());
		if(evaluation != null)
		{
			evaluationDao.delete(evaluation);
		}
		
		FundDAOImpl fundDao = new FundDAOImpl();
		Fund fund = fundDao.findByContext(phaseContext.getId());
		if(fund != null)
		{
			fundDao.delete(fund);
		}
		
		super.delete(phaseContext);
	}
	
	@Override
	public PhaseContext save(PhaseContext phaseContext)
	{
		phaseContext.getIdea().setPhaseContext(phaseContext);
		super.save(phaseContext);
		return phaseContext;
	}
}
