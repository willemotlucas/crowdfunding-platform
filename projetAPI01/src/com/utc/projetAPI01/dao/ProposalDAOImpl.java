package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Proposal;

public class ProposalDAOImpl extends DAOAbstract<Proposal>{
	public ProposalDAOImpl(){
		objName = "Proposal";
	}
	
	public Proposal findByContext(int id){
		Proposal proposal = null;
	    try{
	    	Query query = session.createQuery("from " + objName +" where context = :id");
	    	query.setInteger("id", id);
			proposal = (Proposal) query.uniqueResult();
	    }catch(HibernateException e){
	    	e.printStackTrace();
	    }
		return proposal;
	}
	
	@Override
	public void delete(Proposal proposal)
	{
		super.delete(proposal);
	}
}
