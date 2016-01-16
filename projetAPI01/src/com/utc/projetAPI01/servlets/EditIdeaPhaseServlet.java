package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Redaction;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;

/**
 * Servlet implementation class EditIdeaPhaseServlet
 */
@WebServlet("/EditIdeaPhaseServlet")
public class EditIdeaPhaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditIdeaPhaseServlet() {
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
			request.getRequestDispatcher("editPhase.jsp").forward(request, response);
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
		PhaseContext phaseContext = contextDAO.findByIdea(idea.getId());

		String phase = request.getParameter("phase");
		
		if(!phaseContext.getCurrentPhase().equals(phase.toLowerCase()))
		{
			if(phase.equals("Discussion"))
			{
				phaseContext.setCurrentPhase("discussion");
				DiscussionDAOImpl discussionDao = new DiscussionDAOImpl();
				Discussion discussion = discussionDao.findByContext(phaseContext.getId());
				if(discussion != null)
				{
					discussion.setDatePhase(new Date());
					discussionDao.save(discussion);
				}
				else
				{
					discussion = new Discussion(new Date(), phaseContext);
					discussionDao.save(discussion);
				}
			}
			else if (phase.equals("Redaction"))
			{
				phaseContext.setCurrentPhase("redaction");
				RedactionDAOImpl redactionDao = new RedactionDAOImpl();
				Redaction redaction = redactionDao.findByContext(phaseContext.getId());
				if(redaction != null)
				{
					redaction.setDatePhase(new Date());
					redactionDao.save(redaction);
				}
				else
				{
					redaction = new Redaction(new Date(), "",phaseContext);
					redactionDao.save(redaction);
				}
			}
			else if (phase.equals("Evaluation"))
			{
				phaseContext.setCurrentPhase("evaluation");
				EvaluationDAOImpl evaluationDao = new EvaluationDAOImpl();
				Evaluation evaluation = evaluationDao.findByContext(phaseContext.getId());
				if(evaluation != null)
				{
					evaluation.setDatePhase(new Date());
					evaluationDao.save(evaluation);
				}
				else
				{
					evaluation = new Evaluation(new Date(), phaseContext);
					evaluationDao.save(evaluation);
				}
			}
			else if (phase.equals("Fund"))
			{
				phaseContext.setCurrentPhase("fund");
				FundDAOImpl fundDao = new FundDAOImpl();
				Fund fund = fundDao.findByContext(phaseContext.getId());
				if(fund != null)
				{
					fund.setDatePhase(new Date());
					fundDao.save(fund);
				}
				else
				{
					fund = new Fund(new Date(), phaseContext);
					fundDao.save(fund);
				}
			}
			
			contextDAO.save(phaseContext);
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/ideaDetails?id=" + request.getParameter("id"));
	}

}
