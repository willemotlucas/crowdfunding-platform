package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Servlet implementation class LoadUserIdeasServlet
 */
@WebServlet("/LoadUserIdeasProposedServlet")
public class LoadUserIdeasProposedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUserIdeasProposedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();

		Map<Idea, PhaseContext> ideasWithContext = new HashMap<Idea, PhaseContext>();
		List<Idea> ideas = ideaDAO.findByCreator((Utilisateur)request.getSession().getAttribute("userSession"));
		Iterator<Idea> it = ideas.iterator();
		while(it.hasNext()){
			Idea idea = it.next();
			PhaseContext context = contextDAO.findByIdea(idea.getId());
			ideasWithContext.put(idea, context);
		}
		
		request.setAttribute("ideas", ideasWithContext);
		
		request.getRequestDispatcher("/user/ideas/ideasProposed.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
