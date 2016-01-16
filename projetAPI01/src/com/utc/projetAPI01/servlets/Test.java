package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.CommentsDAOImpl;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    try {
	      /*Query query = session.createQuery("from Fund f where f.id=1");
	      Iterator funds = query.iterate();
	      while (funds.hasNext()) {
	    	Fund fund = (Fund) funds.next();
	        out.println("date = " + fund.getDatePhase().toString() +"</br>");
	        out.println("phase = " + fund.getContext().getCurrentPhase() +"</br>");
	        out.println("idea = " + fund.getContext().getIdea().getName() + "</br></br>");
	      }
	      
	      query = session.createQuery("from Comments");
	      Iterator comments = query.iterate();
	      while (comments.hasNext()) {
	    	Comments comment = (Comments) comments.next();
	        out.println("date = " + comment.getCommentDate().toString() +"</br>");
	        out.println("user = " + comment.getUtilisateur().getNom() +"</br>");
	        out.println("idea = " + comment.getIdea().getName() + "</br>");
	        out.println("description = " + comment.getDescription()+ "</br></br>");
	      }
	      
	      UtilisateurDAOImpl userDao = new UtilisateurDAOImpl();
	      Utilisateur user = userDao.findById(1);
	      if(user != null)
	      {
	    	  out.println("nom = " + user.getNom() +"</br>");
		      out.println("rue = " + user.getAdress().getRue() +"</br></br>");
	      }
	      else
	      {
	    	  out.println("user1 null</br></br>");
	      }
	      
	      Utilisateur user10 = userDao.findById(10);
	      if(user10 != null)
	      {
	    	  out.println("nom = " + user10.getNom() +"</br>");
		      out.println("rue = " + user10.getAdress().getRue() +"</br></br>");
	      }
	      else
	      {
	    	  out.println("user10 null</br></br>");
	      }
	      
	      query = session.createQuery("from Utilisateur u");
	      Iterator utilisateurs = query.iterate();
	      while (utilisateurs.hasNext()) {
	    	  Utilisateur utilisateur = (Utilisateur) utilisateurs.next();
	        out.println("nom = " + utilisateur.getNom() +"</br>");
	        out.println("password = " + utilisateur.getPassword() + "</br>");
	        out.println("rue = " + utilisateur.getAdress().getRue() +"</br></br>");
	      }*/
	      
	      UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
	      Utilisateur userTest = userDAO.findById(1);
	      if(userTest != null)
	      {
	    	  out.println("Nom: "+ userTest.getNom() + "</br>");
	    	  out.println("Prenom: " + userTest.getPrenom() + "</br>");
	    	  out.println("Email: " + userTest.getEmail() + "</br></br>");
	    	  Set<Idea> idees = userTest.getIdeas();
	    	  Iterator<Idea> it = idees.iterator();
	    	  while(it.hasNext())
	    	  {
	    		  Idea idee = it.next();
	    		  out.println("Projet: " + idee.getName() + "</br>");
	    	  }
	    	  
	    	  Set<Comments> comments = userTest.getComments();
	    	  Iterator<Comments> itCo = comments.iterator();
	    	  while(itCo.hasNext())
	    	  {
	    		  Comments co = itCo.next();
	    		  out.println("Comment: "+ co.getDescription()+"</br>" );
	    	  }
	    	  
	    	  Set<MakeFund> funds = userTest.getFunds();
	    	  Iterator<MakeFund> itMa = funds.iterator();
	    	  while(itMa.hasNext())
	    	  {
	    		  MakeFund fu = itMa.next();
	    		  out.println("Montant: "+ fu.getAmount() +"</br>" );
	    		  out.println("Pour: "+ fu.getFund().getContext().getIdea().getName() +"</br>" );
	    	  }
	      }
	      
	    } finally {
	      session.close();
	    }

	    sessionFactory.close();
	    
	    out.println("<h1>Test</h1>");
		
	    out.println("<h1>Max nb comments</h1>");
	    IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
	    Idea idea = ideaDAO.findByMaxComments();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

