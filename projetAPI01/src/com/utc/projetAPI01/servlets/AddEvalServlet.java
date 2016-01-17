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
 * Servlet implementation class AddEvalServlet
 */
@WebServlet("/AddEvalServlet")
public class AddEvalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEvalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = userDAO.findById(idUser);
        
        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> allIdeas = ideaDAO.findByPhase("evaluation");
		
		if(user != null && allIdeas != null){
			request.setAttribute("userBean", user);
	        request.getSession().setAttribute("allIdeas", allIdeas);
			request.getRequestDispatcher("/admin/evals/addEvalForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("add fund");
        

        String utilisateur = request.getParameter("utilisateur");
        int idea = Integer.parseInt(request.getParameter("idea"));
        int feasibility = Integer.parseInt(request.getParameter("feasibility"));
        int marketInterest = Integer.parseInt(request.getParameter("marketInterest"));
        int impact = Integer.parseInt(request.getParameter("impact"));

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findByEmail(utilisateur);

		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		PhaseContext context = contextDAO.findByIdea(idea);
		
		
		if(!utilisateur.isEmpty()
			&& idea > 0
			&& feasibility >= 0
			&& marketInterest >= 0
			&& impact >= 0
			&& context.getCurrentPhase().equals("evaluation")
			) {

			EvaluationDAOImpl evalDAO = new EvaluationDAOImpl();
			Evaluation eval = evalDAO.findByContext(context.getId());
			EvaluationScoreDAOImpl evalScoreDAO = new EvaluationScoreDAOImpl();
			EvaluationScore evalScore = new EvaluationScore(feasibility,marketInterest,impact,user,eval);
	        
			evalScoreDAO.save(evalScore);
			
			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			Idea ideaBean = ideaDAO.findById(idea);

	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("evalScoreBean", evalScore);
	        request.getSession().setAttribute("ideaBean", ideaBean);
	        request.getRequestDispatcher("/admin/evals/addEvalResult.jsp").forward(request, response);
			
		}
		String idUser = request.getParameter("idUser");
		request.setAttribute("id", idUser);
		request.setAttribute("error","Erreur : Vous n'avez pas respecté les contraintes des champs");
		doGet(request, response);
	}

}
