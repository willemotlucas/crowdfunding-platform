package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.APhase;
import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Proposal;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.ProposalDAOImpl;

/**
 * Servlet implementation class AddIdeaServlet
 */
@WebServlet("/AddIdeaServlet")
public class AddIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortDescription");
		String applicationField = request.getParameter("applicationField");
		int fundingRequested = Integer.parseInt(request.getParameter("fundingRequested"));
		if(!name.isEmpty() && name.length() <= 50
			&& !shortDescription.isEmpty() && shortDescription.length() >= 5 && shortDescription.length() <= 255
			&& !applicationField.isEmpty()
			&& fundingRequested > 0){
			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
			ProposalDAOImpl proposalDAO = new ProposalDAOImpl();
			DiscussionDAOImpl discussionDAO = new DiscussionDAOImpl();
			
			Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
			Idea idea = new Idea(name, shortDescription, applicationField, fundingRequested, new Date(Calendar.getInstance().getTime().getTime()), currentUser);
			PhaseContext context = new PhaseContext("discussion", idea);
			Proposal proposal = new Proposal(new Date(Calendar.getInstance().getTime().getTime()), context);
			Discussion discussion = new Discussion(new Date(Calendar.getInstance().getTime().getTime()), context);
			
			ideaDAO.save(idea);
			contextDAO.save(context);
			proposalDAO.save(proposal);
			discussionDAO.save(discussion);
			
			response.sendRedirect(request.getContextPath() + "/user/ideas/proposed");
		}
	}

}
