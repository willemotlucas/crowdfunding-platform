package com.utc.projetAPI01.dao;

import org.hibernate.Session;

public abstract class DAO<T> {
	
	public Session session = ConnectionHibernate.getInstance();
	
	public abstract T find(Integer id);
	
	public abstract T create(T obj);
	
	public abstract T update(T obj);
	
	public abstract void delete(T obj);

}
