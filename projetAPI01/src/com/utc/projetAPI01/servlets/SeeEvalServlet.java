package com.utc.projetAPI01.servlets;

import java.io.IOException;
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
 * Servlet implementation class SeeFundServlet
 */
@WebServlet("/SeeEvalServlet")
public class SeeEvalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeEvalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("see eval");
		
		EvaluationScoreDAOImpl evalScoreDAO = new EvaluationScoreDAOImpl();
		int idEval = Integer.parseInt(request.getParameter("id"));
        EvaluationScore evalScore = evalScoreDAO.findById(idEval);
        
		if(evalScore != null){
			request.setAttribute("evalScoreBean", evalScore);
			request.setAttribute("userBean", evalScore.getUtilisateur());
			request.setAttribute("ideaBean", evalScore.getEvaluation().getContext().getIdea());
			request.getRequestDispatcher("/admin/evals/seeEval.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
