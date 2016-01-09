package com.utc.projetAPI01.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Utilisateur;

public class CommentsDAOImpl extends DAOAbstract<Comments>{
	public CommentsDAOImpl(){
		objName = "Comments";
	}
	
	@SuppressWarnings("unchecked")
	public List<Comments> findByIdea(int id){
		List<Comments> comments = new ArrayList<Comments>();
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where idea = :id order by commentDate desc");
	    	query.setInteger("id", id);
	    	comments = query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return comments;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comments> findByUser(Utilisateur user){
		List<Comments> comments = new ArrayList<Comments>();
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where utilisateur = :id order by commentDate desc");
	    	query.setInteger("id", user.getId());
	    	comments = query.list();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return comments;
	}
}
