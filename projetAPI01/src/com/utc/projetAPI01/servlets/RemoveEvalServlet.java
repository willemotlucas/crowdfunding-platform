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
 * Servlet implementation class RemoveEvalServlet
 */
@WebServlet("/RemoveEvalServlet")
public class RemoveEvalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveEvalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("remove eval");

        EvaluationScoreDAOImpl evalScoreDAO = new EvaluationScoreDAOImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        EvaluationScore evalScore = evalScoreDAO.findById(id);
        evalScoreDAO.delete(evalScore);
        request.getSession().setAttribute("userBean", evalScore.getUtilisateur());
        request.getSession().setAttribute("evalScoreBean", evalScore);
        request.getSession().setAttribute("ideaBean", evalScore.getEvaluation().getContext().getIdea());
        request.getRequestDispatcher("/admin/evals/removeEval.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
