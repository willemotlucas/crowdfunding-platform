package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
	    

	    	long dateTest = new Date().getTime();
	    	Date dateTest2 = new Date();
	    	out.println(dateTest2 + "</br>");

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

