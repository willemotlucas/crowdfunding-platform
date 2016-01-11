package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;

/**
 * Servlet implementation class AddEvaluationServlet
 */
@WebServlet("/AddEvaluationServlet")
public class AddEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEvaluationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax request receive !");
		int idIdea = Integer.parseInt(request.getParameter("idIdea"));
		int feasibility = Integer.parseInt(request.getParameter("feasibility"));
		int marketInterest = Integer.parseInt(request.getParameter("marketInterest"));
		int impact = Integer.parseInt(request.getParameter("impact"));
		
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("userSession");
		
		if(idIdea > 0 
			&& feasibility >= 0 && feasibility <= 10
			&& marketInterest >= 0 && marketInterest <= 10
			&& impact >= 0 && marketInterest <= 10)
		{
			
			PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
			EvaluationDAOImpl evaluationDAO = new EvaluationDAOImpl();
			EvaluationScoreDAOImpl evaluationScoreDAO = new EvaluationScoreDAOImpl();
			
			PhaseContext context = contextDAO.findByIdea(idIdea);
			Evaluation evaluation = evaluationDAO.findByContext(context.getId());
			
			System.out.println("evaluation id : " + evaluation.getId());
			System.out.println("context id : " + context.getId());

			if(evaluationScoreDAO.findByUserAndEvaluation(user, evaluation.getId()) == null){ //User never voted for this discussion
				EvaluationScore evaluationScore = new EvaluationScore(feasibility, marketInterest, impact, user, evaluation);
				System.out.println("trying to save pledge");
				evaluationScoreDAO.save(evaluationScore);
			} else {
				System.out.println("user already evaluate this idea !");
			}
		}
	}

}
