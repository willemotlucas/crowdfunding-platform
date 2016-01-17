package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.APhase;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Utilisateur;

public class MakeFundDAOImpl extends DAOAbstract<MakeFund>{
	
	public MakeFundDAOImpl(){
		objName = "MakeFund";
	}
	
	public Long findCollectedAmountByFund(int idFund){
		Long collectedAmount = new Long(0);

		try
	    {
	    	Query query = session.createQuery("select sum(m.amount) from " + objName +" m where fund = :id");
	    	query.setInteger("id", idFund);
	    	collectedAmount = (Long) query.uniqueResult();
	    	if(collectedAmount == null)
	    		collectedAmount = new Long(0);
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return collectedAmount;
	}
	
	@SuppressWarnings("unchecked")
	public List<MakeFund> findByUser(Utilisateur user){
		List<MakeFund> funds = new ArrayList<MakeFund>();
		
		try
	    {
	    	Query query = session.createQuery("from " + objName +" m where utilisateur = :id");
	    	query.setInteger("id", user.getId());
	    	funds = query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return funds;
	}
	
	public MakeFund findByUserAndFund(Utilisateur user, int idFund){
		MakeFund makeFund = null;
		
		try
	    {
	    	Query query = session.createQuery("from " + objName +" m where utilisateur = :idUser and fund = :idFund");
	    	query.setInteger("idUser", user.getId());
	    	query.setInteger("idFund", idFund);
	    	makeFund = (MakeFund) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		
		return makeFund;
	}
	
	public int findNbMakeFundByUser(Utilisateur user){
		int nbMakeFund = 0;
		
		try
	    {
	    	Query query = session.createQuery("select count(*) from " + objName +" where utilisateur = :idUser");
	    	query.setInteger("idUser", user.getId());
	    	try{
	    		nbMakeFund = ((Long) query.iterate().next()).intValue();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		nbMakeFund = 0;
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		
		return nbMakeFund;
	}
	
	public int findNbMakeFundByFund(int idFund){
		int nbMakeFund = 0;
		
		try
	    {
	    	Query query = session.createQuery("select count(*) from " + objName +" where fund = :idFund");
	    	query.setInteger("idFund", idFund);
	    	try{
	    		nbMakeFund = ((Long) query.iterate().next()).intValue();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		nbMakeFund = 0;
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		
		return nbMakeFund;
	}
	
	@Override
	public void delete(MakeFund makeFund)
	{
		makeFund.getFund().getFunds().remove(makeFund);
		makeFund.getUtilisateur().getFunds().remove(makeFund);
		super.delete(makeFund);
	}
	
	public List<MakeFund> findByPhase(APhase phase){
		List<MakeFund> funds = new ArrayList<MakeFund>();
		
		try
	    {
	    	Query query = session.createQuery("from " + objName +" m where fund = :id");
	    	query.setInteger("id", phase.getId());
	    	funds = query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return funds;
	}
	
	@Override
	public MakeFund save(MakeFund makeFund)
	{
		makeFund.getFund().getFunds().add(makeFund);
		makeFund.getUtilisateur().getFunds().add(makeFund);
		super.save(makeFund);
		return makeFund;
	}

}
