package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;

/**
 * Servlet implementation class AddPledgeServlet
 */
@WebServlet("/AddPledgeServlet")
public class AddPledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPledgeServlet() {
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
		int amount = Integer.parseInt(request.getParameter("amount"));
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("userSession");
		System.out.println("amount : " + amount);
		
		if(idIdea > 0 && amount > 0 && amount <= 5000){
			PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
			FundDAOImpl fundDAO = new FundDAOImpl();
			MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
			PhaseContext context = contextDAO.findByIdea(idIdea);
			Fund fund = fundDAO.findByContext(context.getId());
			
			System.out.println("fund id : " + fund.getId());
			System.out.println("context id : " + fund.getId());

			if(makeFundDAO.findByUserAndFund(user, fund.getId()) == null){ //User never voted for this discussion
				MakeFund makeFund = new MakeFund(amount, user, fund);
				System.out.println("trying to save pledge");
				makeFundDAO.save(makeFund);
			} else {
				System.out.println("user already voted for this idea !");
			}
		}
	}

}
