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
 * Servlet implementation class EditFundServlet
 */
@WebServlet("/EditFundServlet")
public class EditFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
		int idFund = Integer.parseInt(request.getParameter("id"));
        MakeFund makeFund = makeFundDAO.findById(idFund);

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        List<Utilisateur> allUsers = userDAO.findAll();

        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> allIdeas = ideaDAO.findAll();

		if(makeFund != null){
			request.setAttribute("allUsers", allUsers);
			request.setAttribute("allIdeas", allIdeas);		
			request.setAttribute("makeFundBean", makeFund);
			request.setAttribute("userBean", makeFund.getUtilisateur());
			request.setAttribute("ideaBean", makeFund.getFund().getContext().getIdea());
			request.getRequestDispatcher("/admin/funds/editFundForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("edit fund");

        MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
        int idMakeFund = Integer.parseInt(request.getParameter("id"));
        MakeFund makeFund = makeFundDAO.findById(idMakeFund);        

        String utilisateur = request.getParameter("utilisateur");
        int idea = Integer.parseInt(request.getParameter("idIdea"));
        int amount = Integer.parseInt(request.getParameter("montant"));

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findByEmail(utilisateur);

		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		PhaseContext context = contextDAO.findByIdea(idea);
		
		
		if(!utilisateur.isEmpty()
			&& idea > 0
			&& amount > 0
			&& context.getCurrentPhase().equals("fund")
			) {

			FundDAOImpl fundDAO = new FundDAOImpl();
			Fund fund = fundDAO.findByContext(context.getId());
			makeFund.setAmount(amount);
			makeFund.setFund(fund);
			makeFund.setUtilisateur(user);
	        
			makeFundDAO.save(makeFund);

			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			Idea ideaBean = ideaDAO.findById(idea);

	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("makeFundBean", makeFund);
	        request.getSession().setAttribute("ideaBean", ideaBean);
	        request.getRequestDispatcher("/admin/funds/editFundResult.jsp").forward(request, response);
			
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
