package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Redaction;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;

/**
 * Servlet implementation class EditIdeaServlet
 */
@WebServlet("/EditIdeaServlet")
public class EditIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		int idIdea = Integer.parseInt(request.getParameter("id"));
		Idea idea = ideaDAO.findById(idIdea);
		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		PhaseContext context = contextDAO.findByIdea(idea.getId());
		
		if(idea != null){
			if(context.getCurrentPhase().equals("redaction")){
				RedactionDAOImpl redactionDAO = new RedactionDAOImpl();
				Redaction redaction = redactionDAO.findByContext(context.getId());
				request.setAttribute("redaction", redaction);
			}

			request.setAttribute("idea", idea);
			request.setAttribute("context", context);
			request.getRequestDispatcher("editIdea.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		int idIdea = Integer.parseInt(request.getParameter("id"));
		Idea idea = ideaDAO.findById(idIdea);

		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortDescription");
		String applicationField = request.getParameter("applicationField");
		String longDescription = request.getParameter("longDescription");
		int fundingRequested = Integer.parseInt(request.getParameter("fundingRequested"));
		
		if(!name.isEmpty() && name.length() <= 50
			&& !shortDescription.isEmpty() && shortDescription.length() >= 5 && shortDescription.length() <= 255
			&& !applicationField.isEmpty()
			&& fundingRequested > 0){
			
			if(longDescription != null)
			{
				if(!longDescription.isEmpty() && longDescription.length() >= 5 && longDescription.length() <= 255){
					RedactionDAOImpl redactionDAO = new RedactionDAOImpl();
					PhaseContext context = contextDAO.findByIdea(idea.getId());
					Redaction redaction = redactionDAO.findByContext(context.getId());
					
					redaction.setLongDescription(longDescription);
					redactionDAO.save(redaction);
				}
			}
			
			
			idea.setName(name);
			idea.setShortDescription(shortDescription);
			idea.setApplicationField(applicationField);
			idea.setFundingRequested(fundingRequested);
			
			ideaDAO.save(idea);
			
			if(currentUser.getAccountType().equals("normalUser"))
			{
				response.sendRedirect(request.getContextPath() + "/user/ideas/proposed");
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/admin/ideaDetails?id=" + request.getParameter("id"));
			}
			
		}
	}

}
