package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.IdeaDAOImpl;

/**
 * Servlet implementation class DeleteIdeaServlet
 */
@WebServlet("/DeleteIdeaServlet")
public class DeleteIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entre dans le doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax post request receive");
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();

		int idIdea = Integer.parseInt(request.getParameter("idIdea"));
		Idea idea = ideaDAO.findById(idIdea);
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
		if(currentUser.getAccountType().equals("normalUser") && idea.getMadeBy() == currentUser){ //If the current user is the owner of the idea, he may delete it
			if(idea != null)
			{
				ideaDAO.delete(idea);
			}
			
		}
		else if(currentUser.getAccountType().equals("admin"))
		{
			System.out.println("entre dans le else if");
			if(idea != null)
			{
				ideaDAO.delete(idea);
			}
			response.sendRedirect(request.getContextPath() + "/admin/manageIdeas");
		}
		
	}

}
