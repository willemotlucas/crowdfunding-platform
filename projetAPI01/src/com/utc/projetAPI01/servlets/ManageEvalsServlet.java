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
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;

/**
 * Servlet implementation class ManageEvalsServlet
 */
@WebServlet("/ManageEvalsServlet")
public class ManageEvalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageEvalsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("get all evaluations of the application");        
	    EvaluationScoreDAOImpl evalDAO = new EvaluationScoreDAOImpl();
	    List<EvaluationScore> allEvals = evalDAO.findAll();

        request.getSession().setAttribute("allEvals", allEvals);
        request.getRequestDispatcher("/admin/evals/manageEvals.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
