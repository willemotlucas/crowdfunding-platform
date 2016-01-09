package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;

/**
 * Servlet implementation class LoadUserIdeasPledgedServlet
 */
@WebServlet("/LoadUserIdeasPledgedServlet")
public class LoadUserIdeasPledgedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUserIdeasPledgedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
		
		List<MakeFund> makeFund = makeFundDAO.findByUser((Utilisateur) request.getSession().getAttribute("userSession"));
		
		request.setAttribute("makeFund", makeFund);
		
		request.getRequestDispatcher("/user/ideas/ideasPledged.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
