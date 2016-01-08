package com.utc.projetAPI01.dao;

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
	
	public Map<Comments, Utilisateur> findByIdea(int id){
		Map<Comments, Utilisateur> commentsWithUser = new HashMap<Comments, Utilisateur>();
		
	    try
	    {
	    	Query query = sessionLecture.createQuery("from " + objName +" where idea = :id order by commentDate desc");
	    	query.setInteger("id", id);
	    	List<Comments> comments = query.list();
	    	Iterator<Comments> it = comments.iterator();
	    	while(it.hasNext()){
	    		Comments comment = it.next();
		    	commentsWithUser.put(comment, comment.getUtilisateur());
	    	}
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return commentsWithUser;
	}
}
