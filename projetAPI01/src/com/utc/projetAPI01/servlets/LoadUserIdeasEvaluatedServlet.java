package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;

/**
 * Servlet implementation class LoadUserIdeasEvaluatedServlet
 */
@WebServlet("/LoadUserIdeasEvaluatedServlet")
public class LoadUserIdeasEvaluatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUserIdeasEvaluatedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
		EvaluationScoreDAOImpl evaluationScoreDAO = new EvaluationScoreDAOImpl();
		
		List<Thumb> thumbs = thumbDAO.findByUser((Utilisateur)request.getSession().getAttribute("userSession"));
		List<EvaluationScore> evaluations = evaluationScoreDAO.findByUser((Utilisateur) request.getSession().getAttribute("userSession"));
		
		request.setAttribute("thumbs", thumbs);
		request.setAttribute("evaluations", evaluations);
		
		request.getRequestDispatcher("/user/ideas/ideasEvaluated.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
