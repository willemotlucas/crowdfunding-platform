package com.utc.projetAPI01.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Adress;

public class AdressDAOImpl extends DAOAbstract<Adress> {
	
	public AdressDAOImpl()
	{
		objName = "Adress";
	}
	
	@Override
	public void delete(Adress adress)
	{
		super.delete(adress);
	}
}
