package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.utc.projetAPI01.beans.*;

public class ConnectionHibernateEcriture {
	
	private static Session session;
	
	private ConnectionHibernateEcriture()
	{
	}
	
	public static Session getInstance(){
		if(session == null){
			Configuration config = new Configuration();
			config.addClass(Adress.class);
			config.addClass(Comments.class);
			config.addClass(Discussion.class);
			config.addClass(Evaluation.class);
			config.addClass(EvaluationScore.class);
			config.addClass(Fund.class);
			config.addClass(Idea.class);
			config.addClass(MakeFund.class);
			config.addClass(PhaseContext.class);
			config.addClass(Proposal.class);
			config.addClass(Redaction.class);
			config.addClass(Thumb.class);
			config.addClass(Utilisateur.class);
			
			SessionFactory sessionFactory = config.buildSessionFactory();
			try {
				session = sessionFactory.openSession();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}		
		return session;	
	}


}
