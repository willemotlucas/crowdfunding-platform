package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Redaction;
import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;

/**
 * Servlet implementation class LoadAdminHomepageServlet
 */
@WebServlet("/LoadAdminHomepageServlet")
public class LoadAdminHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;	
	private static final int NB_DAYS_REDACTION = 10;
	private static final int NB_DAYS_EVALUATION = 10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAdminHomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		EvaluationDAOImpl evaluationDao = new EvaluationDAOImpl();
		RedactionDAOImpl redactionDao = new RedactionDAOImpl();
		List<Idea> allEvaluations = ideaDao.findAllEvaluation();
		List<Idea> allRedactions = ideaDao.findAllRedaction();
		
		Map<Idea, Evaluation> evaluations = new HashMap<Idea, Evaluation>();
		Map<Idea, Redaction> redactions = new HashMap<Idea, Redaction>();
		Map<Integer, Integer> joursRestant = new HashMap<Integer, Integer>();
		
		Iterator<Idea> itRedac = allRedactions.iterator();
		while(itRedac.hasNext())
		{
			Idea idea = itRedac.next();
			Redaction redaction = redactionDao.findByContext(idea.getPhaseContext().getId());
			int nbDaysSincePhase = (int) ((new Date().getTime() - redaction.getDatePhase().getTime()) / DAY_IN_MILLIS);
			int nbDaysRemains = NB_DAYS_REDACTION - nbDaysSincePhase;
			if(nbDaysRemains < 0){
				nbDaysRemains = 0;
			}
			if(nbDaysRemains == 0){
				joursRestant.put(idea.getId(), nbDaysRemains);				
				redactions.put(idea, redaction);			
			}
		}
		
		Iterator<Idea> itEval = allEvaluations.iterator();
		while(itEval.hasNext())
		{
			Idea idea = itEval.next();
			Evaluation evaluation = evaluationDao.findByContext(idea.getPhaseContext().getId());
			int nbDaysSincePhase = (int) ((new Date().getTime() - evaluation.getDatePhase().getTime()) / DAY_IN_MILLIS);
			int nbDaysRemains = NB_DAYS_EVALUATION - nbDaysSincePhase;
			if(nbDaysRemains < 0){
				nbDaysRemains = 0;
			}
			if(nbDaysRemains == 0){
				joursRestant.put(idea.getId(), nbDaysRemains);
				evaluations.put(idea, evaluation);
			}
		}
		
		request.setAttribute("allEvaluations", allEvaluations);
		request.setAttribute("allRedactions", allRedactions);
		request.setAttribute("evaluations", evaluations);
		request.setAttribute("redactions", redactions);
		request.setAttribute("joursRestant", joursRestant);

		
		request.getRequestDispatcher("/admin/homeAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
