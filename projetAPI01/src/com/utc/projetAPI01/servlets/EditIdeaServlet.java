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
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;

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
			request.setAttribute("idea", idea);
			request.setAttribute("context", context);
			System.out.println("redirect to editIdea");
			request.getRequestDispatcher("editIdea.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		int idIdea = Integer.parseInt(request.getParameter("id"));
		Idea idea = ideaDAO.findById(idIdea);

		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortDescription");
		String applicationField = request.getParameter("applicationField");
		int fundingRequested = Integer.parseInt(request.getParameter("fundingRequested"));
		
		if(!name.isEmpty() && name.length() <= 50
			&& !shortDescription.isEmpty() && shortDescription.length() >= 5 && shortDescription.length() <= 255
			&& !applicationField.isEmpty()
			&& fundingRequested > 0){
			
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
