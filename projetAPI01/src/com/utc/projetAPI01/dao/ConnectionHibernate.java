package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionHibernate {
	
	private static Session session;
	
	private ConnectionHibernate()
	{
	}
	
	public static Session getInstance(){
		if(session == null){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			try {
				session = sessionFactory.openSession();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}		
		return session;	
	}

}
