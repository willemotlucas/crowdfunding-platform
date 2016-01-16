package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Redaction;

public class FundDAOImpl extends DAOAbstract<Fund>{
	public FundDAOImpl(){
		objName = "Fund";
	}
	
	@SuppressWarnings("unchecked")
	public List<Fund> find3Last(){
		List<Fund> funds = new ArrayList<Fund>();
		
		try
	    {
	    	Query query = session.createQuery("from " + objName +" order by datePhase desc");
	    	query.setMaxResults(3);
		    funds = (List<Fund>) query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return funds;
	}
	
	public Fund findByContext(int id){
		Fund fund = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where context = :id");
	    	query.setInteger("id", id);
	    	fund = (Fund) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return fund;
	}
	
	@Override
	public void delete(Fund fund)
	{
		MakeFundDAOImpl makeFundDao = new MakeFundDAOImpl();
		Iterator<MakeFund> itMakeFund = fund.getFunds().iterator();
		while(itMakeFund.hasNext())
		{
			MakeFund makeFund = itMakeFund.next();
			makeFundDao.delete(makeFund);
		}
		
		super.delete(fund);
	}
}
