package com.utc.projetAPI01.dao;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;

public class UtilisateurDAOImpl extends DAOAbstract<Utilisateur> {
	
	public UtilisateurDAOImpl()
	{
		objName = "Utilisateur";
	}
	
	public Utilisateur findByEmail(String email) {
		
		Utilisateur user = null;
		
	    try
	    {
	    	Query query = session.createQuery("from " + objName +" where email = :email");
	    	query.setString("email", email);
			user = (Utilisateur) query.uniqueResult();
	    }
	    catch(HibernateException e)
	    {
	    	e.printStackTrace();
	    }
		return user;
	}
	
	@Override
	public void delete(Utilisateur utilisateur)
	{
		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		Iterator<Idea> itIdea = utilisateur.getIdeas().iterator();
		while(itIdea.hasNext())
		{
			Idea idea = itIdea.next();
			ideaDao.delete(idea);
		}
		
		CommentsDAOImpl commentsDao = new CommentsDAOImpl();
		Iterator<Comments> itComments = utilisateur.getComments().iterator();
		while(itComments.hasNext())
		{
			Comments comment = itComments.next();
			commentsDao.delete(comment);
		}
		
		EvaluationScoreDAOImpl evalDao = new EvaluationScoreDAOImpl();
		Iterator<EvaluationScore> itEval = utilisateur.getScores().iterator();
		while(itEval.hasNext())
		{
			EvaluationScore eval = itEval.next();
			evalDao.delete(eval);
		}
		
		MakeFundDAOImpl makeFundDao = new MakeFundDAOImpl();
		Iterator<MakeFund> itMake = utilisateur.getFunds().iterator();
		while(itMake.hasNext())
		{
			MakeFund mf = itMake.next();
			makeFundDao.delete(mf);
		}
		
		ThumbDAOImpl thumbDao = new ThumbDAOImpl();
		Iterator<Thumb> itThumb = utilisateur.getThumbs().iterator();
		while(itThumb.hasNext())
		{
			Thumb thumb = itThumb.next();
			thumbDao.delete(thumb);
		}
		
		AdressDAOImpl adressDao = new AdressDAOImpl();
		Adress adress = utilisateur.getAdress();
		
		super.delete(utilisateur);
		
		if(adress != null)
		{
			adressDao.delete(adress);
		}
	}
	
	@Override
	public Utilisateur save(Utilisateur utilisateur)
	{
		utilisateur.getAdress().getUtilisateurs().add(utilisateur);
		super.save(utilisateur);
		return utilisateur;
	}

}
