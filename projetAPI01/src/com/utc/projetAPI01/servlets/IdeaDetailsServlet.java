package com.utc.projetAPI01.servlets;

import com.utc.projetAPI01.beans.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class IdeaDetailsServlet
 */
@WebServlet("/IdeaDetailsServlet")
public class IdeaDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdeaDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get details of an idea");
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
		String redirect = "";

		Idea idea = ideaDAO.findById(Integer.parseInt(request.getParameter("id")));
		PhaseContext context = contextDAO.findByIdea(idea.getId());
		request.setAttribute("context", context);
		request.setAttribute("creator", idea.getMadeBy());
		
		//Check the phase of the idea in order to display right details and perform right redirection
		if(context.getCurrentPhase().equals("discussion")){
			DiscussionDAOImpl discussionDAO = new DiscussionDAOImpl();
			ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
			
			Discussion discussion = discussionDAO.findByContext(context.getId());
			int score = thumbDAO.findScoreByIdea(discussion.getId());
			request.setAttribute("idea", idea);
			request.setAttribute("discussion", discussion);
			request.setAttribute("score", score);

			redirect = "/user/" + context.getCurrentPhase() + "Details.jsp";
		}
		else if(context.getCurrentPhase().equals("redaction")){
			RedactionDAOImpl redactionDAO = new RedactionDAOImpl();
			
			Redaction redaction = redactionDAO.findByContext(context.getId());
			request.setAttribute("redaction", redaction);
			redirect = "/user/" + context.getCurrentPhase() + "Details.jsp";
		}
		else if(context.getCurrentPhase().equals("evaluation")){
			
		}
		else if(context.getCurrentPhase().equals("fund")){
			
		}
		
		request.getRequestDispatcher(redirect).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
