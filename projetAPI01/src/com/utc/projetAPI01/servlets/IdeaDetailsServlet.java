package com.utc.projetAPI01.servlets;

import com.utc.projetAPI01.beans.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.dao.CommentsDAOImpl;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class IdeaDetailsServlet
 */
@WebServlet("/IdeaDetailsServlet")
public class IdeaDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdeaDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get details of an idea");
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		CommentsDAOImpl commentsDAO = new CommentsDAOImpl();

		Idea idea = ideaDAO.findById(Integer.parseInt(request.getParameter("id")));
		PhaseContext context = contextDAO.findByIdea(idea.getId());
		Map<Comments, Utilisateur> comments = commentsDAO.findByIdea(idea.getId());

		request.setAttribute("idea", idea);
		request.setAttribute("context", context);
		request.setAttribute("creator", idea.getMadeBy());
		request.setAttribute("comments", comments);
		
		//Check the phase of the idea in order to display right details and perform right redirection
		//The idea requested is in discussion phase
		if(context.getCurrentPhase().equals("discussion")){
			DiscussionDAOImpl discussionDAO = new DiscussionDAOImpl();
			ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
			
			Discussion discussion = discussionDAO.findByContext(context.getId());
			Map<String, Integer> score = thumbDAO.findScoreByIdea(discussion.getId());
			request.setAttribute("discussion", discussion);
			request.setAttribute("score", score);
		}
		
		//The idea requested is in redaction phase
		else if(context.getCurrentPhase().equals("redaction")){
			RedactionDAOImpl redactionDAO = new RedactionDAOImpl();
			
			Redaction redaction = redactionDAO.findByContext(context.getId());
			request.setAttribute("redaction", redaction);
		}
		
		//The idea requested is in evaluation phase
		else if(context.getCurrentPhase().equals("evaluation")){
			EvaluationDAOImpl evaluationDAO = new EvaluationDAOImpl();
			EvaluationScoreDAOImpl evaluationScoreDAO = new EvaluationScoreDAOImpl();
			
			Evaluation evaluation = evaluationDAO.findByContext(context.getId());
			System.out.println("evaluation id : " + evaluation.getId());
			List<EvaluationScore> evaluationScores = evaluationScoreDAO.findByIdeaInEvaluation(evaluation.getId());
			if(!evaluationScores.isEmpty()){
				float feasibility = 0;
				float impact = 0;
				float market = 0;
				float mean = 0;
				Iterator<EvaluationScore> it = evaluationScores.iterator();
				while(it.hasNext()){
					EvaluationScore eval = it.next();
					feasibility += eval.getFeasibility();
					impact += eval.getImpact();
					market += eval.getMarketInterest();
					mean += eval.getMean();
				}
				
				feasibility = feasibility/evaluationScores.size();
				impact = impact/evaluationScores.size();
				market = market/evaluationScores.size();
				mean = mean/evaluationScores.size();
				
				System.out.println("faisability : " + feasibility);
				System.out.println("market : " + market);
				System.out.println("impact : " + impact);
				request.setAttribute("feasibility", feasibility);
				request.setAttribute("marketInterest", market);
				request.setAttribute("impact", impact);
				request.setAttribute("mean", mean);
			}
			
			request.setAttribute("evaluation", evaluation);
		}
		
		//The idea requested is in funding phase
		else if(context.getCurrentPhase().equals("fund")){
			
		}
		
		request.getRequestDispatcher("/user/" + context.getCurrentPhase() + "Details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
