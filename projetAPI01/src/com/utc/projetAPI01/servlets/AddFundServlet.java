package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.AdressDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class AddFundServlet
 */
@WebServlet("/AddFundServlet")
public class AddFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("get user and ideas");

        //UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = userDAO.findById(idUser);
        
        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> allIdeas = ideaDAO.findAll();
		
		if(user != null && allIdeas != null){
			request.setAttribute("userBean", user);
	        request.getSession().setAttribute("allIdeas", allIdeas);
			request.getRequestDispatcher("/admin/funds/addFundForm.jsp").forward(request, response);
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
			MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
			MakeFund makeFund = new MakeFund(amount,user,fund);
	        
			makeFundDAO.save(makeFund);
			
			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			Idea ideaBean = ideaDAO.findById(idea);

	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("makeFundBean", makeFund);
	        request.getSession().setAttribute("ideaBean", ideaBean);
	        request.getRequestDispatcher("/admin/funds/addFundResult.jsp").forward(request, response);
			
		}
		String idUser = request.getParameter("idUser");
		request.setAttribute("id", idUser);
		request.setAttribute("error","Erreur : Vous n'avez pas respecté les contraintes des champs");
		doGet(request, response);
	}

}
