package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Redaction;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;

/**
 * Servlet implementation class AddThumbsServlet
 */
@WebServlet("/AddThumbsServlet")
public class AddThumbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddThumbsServlet() {
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
		int score = Integer.parseInt(request.getParameter("score"));
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("userSession");
		System.out.println("score : " + score);
		
		if(idIdea > 0 && (score == 1 || score == -1)){
			PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
			DiscussionDAOImpl discussionDAO = new DiscussionDAOImpl();
			ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
			PhaseContext context = contextDAO.findByIdea(idIdea);
			Discussion discussion = discussionDAO.findByContext(context.getId());
			
			System.out.println("discussion id : " + discussion.getId());
			System.out.println("context id : " + discussion.getId());

			if(thumbDAO.findByUserAndDiscussion(user, discussion.getId()) == null){ //User never voted for this discussion
				Thumb thumb = new Thumb(score, user, discussion);
				System.out.println("trying to save thumbs");
				thumbDAO.save(thumb);
				
				int totalScore = thumbDAO.findPositiveScoreByDiscussion(discussion.getId()) - thumbDAO.findNegativeScoreByDiscussion(discussion.getId());
				System.out.println("score total : " + totalScore);
				if(totalScore >= 10){
					//Idea can pass in redaction phase
					RedactionDAOImpl redactionDAO = new RedactionDAOImpl();
					Redaction redaction = new Redaction(new Date(Calendar.getInstance().getTime().getTime()), context);
					redactionDAO.save(redaction);
					context.setCurrentPhase("redaction");
					contextDAO.save(context);
				}
			} else {
				System.out.println("user already voted for this idea !");
			}
		}
		
		if(user.getAccountType().equals("admin"))
		{
			request.getRequestDispatcher("/admin/ideaDetails?id=" + idIdea).forward(request, response);
		}
	}

}
