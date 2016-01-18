package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class EditEvalServlet
 */
@WebServlet("/EditEvalServlet")
public class EditEvalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEvalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EvaluationScoreDAOImpl evalScoreDAO = new EvaluationScoreDAOImpl();
		int idEval = Integer.parseInt(request.getParameter("id"));
        EvaluationScore evalScore = evalScoreDAO.findById(idEval);

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        List<Utilisateur> allUsers = userDAO.findAll();

        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> allIdeas = ideaDAO.findAll();
        
		if(evalScore != null){
			request.setAttribute("allUsers", allUsers);
			request.setAttribute("allIdeas", allIdeas);
			request.setAttribute("evalScoreBean", evalScore);
			request.setAttribute("userBean", evalScore.getUtilisateur());
			request.setAttribute("ideaBean", evalScore.getEvaluation().getContext().getIdea());
			request.getRequestDispatcher("/admin/evals/editEvalForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("edit eval");

        EvaluationScoreDAOImpl evalScoreDAO = new EvaluationScoreDAOImpl();
        int idEvalScore = Integer.parseInt(request.getParameter("id"));
        EvaluationScore evalScore = evalScoreDAO.findById(idEvalScore);
        
        String utilisateur = request.getParameter("utilisateur");
        int idea = Integer.parseInt(request.getParameter("idIdea"));
        int feasibility = Integer.parseInt(request.getParameter("feasibility"));
        int marketInterest = Integer.parseInt(request.getParameter("marketInterest"));
        int impact = Integer.parseInt(request.getParameter("impact"));

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findByEmail(utilisateur);

		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		PhaseContext context = contextDAO.findByIdea(idea);
		
		
		if(!utilisateur.isEmpty()
			&& idea > 0
			&& feasibility > 0
			&& marketInterest > 0
			&& impact > 0
			) {


	        EvaluationDAOImpl evalDAO = new EvaluationDAOImpl();
			Evaluation eval = evalDAO.findByContext(context.getId());
			
			evalScore.setEvaluation(eval);
			evalScore.setFeasibility(feasibility);
			evalScore.setImpact(impact);
			evalScore.setMarketInterest(marketInterest);
			evalScore.setUtilisateur(user);
	        
			evalScoreDAO.save(evalScore);

			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			Idea ideaBean = ideaDAO.findById(idea);

	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("evalScoreBean", evalScore);
	        request.getSession().setAttribute("ideaBean", ideaBean);
	        request.getRequestDispatcher("/admin/evals/editEvalResult.jsp").forward(request, response);
			
		}
		else{
			String idUser = request.getParameter("idUser");
			request.setAttribute("id", idUser);
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			request.setAttribute("error","Erreur : Vous n'avez pas respecté les contraintes des champs");
			doGet(request, response);
		}
	
	}

}
