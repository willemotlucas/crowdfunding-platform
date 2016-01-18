package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;

/**
 * Servlet implementation class ChangePhaseServlet
 */
@WebServlet("/ChangePhaseServlet")
public class ChangePhaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePhaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		RedactionDAOImpl redactionDao = new RedactionDAOImpl();
		EvaluationDAOImpl evaluationDao = new EvaluationDAOImpl();
		FundDAOImpl fundDao = new FundDAOImpl();
		PhaseContextDAOImpl phaseContextDao = new PhaseContextDAOImpl();
		int idIdea = Integer.parseInt(request.getParameter("id"));
		Idea idea = ideaDao.findById(idIdea);
		PhaseContext phaseContext = idea.getPhaseContext();
		
		if(phaseContext.getCurrentPhase().equals("redaction"))
		{
			phaseContext.setCurrentPhase("evaluation");
			Evaluation evaluation = evaluationDao.findByContext(phaseContext.getId());
			if(evaluation != null)
			{
				evaluation.setDatePhase(new Date());
			}
			else
			{
				evaluation = new Evaluation(new Date(), phaseContext);
			}
			evaluationDao.save(evaluation);
		}
		else if(phaseContext.getCurrentPhase().equals("evaluation"))
		{
			phaseContext.setCurrentPhase("fund");
			Fund fund = fundDao.findByContext(phaseContext.getId());
			if(fund != null)
			{
				fund.setDatePhase(new Date());
			}
			else
			{
				fund = new Fund(new Date(), phaseContext);
			}
			fundDao.save(fund);
		}
		phaseContextDao.save(phaseContext);
		
		response.sendRedirect(request.getContextPath() + "/admin/homepage");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
