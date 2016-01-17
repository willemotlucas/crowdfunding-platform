package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Evaluation;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.EvaluationDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class AddScoreServlet
 */
@WebServlet("/AddScoreServlet")
public class AddScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = userDAO.findById(idUser);
        
        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> allIdeas = ideaDAO.findByPhase("discussion");
		
		if(user != null && allIdeas != null){
			request.setAttribute("userBean", user);
	        request.getSession().setAttribute("allIdeas", allIdeas);
			request.getRequestDispatcher("/admin/scores/addScoreForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("add score");
        

        String utilisateur = request.getParameter("utilisateur");
        int idea = Integer.parseInt(request.getParameter("idea"));
        int score = Integer.parseInt(request.getParameter("score"));

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findByEmail(utilisateur);

		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		PhaseContext context = contextDAO.findByIdea(idea);

		DiscussionDAOImpl discussDAO = new DiscussionDAOImpl();
		Discussion discuss = discussDAO.findByContext(context.getId());
		ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
		
		if(thumbDAO.findByUserAndDiscussion(user, discuss.getId()) != null){
			request.setAttribute("error","Cet utilisateur a déjà voté pour cette idée");
			doGet(request, response);
		}
		else if(!utilisateur.isEmpty()
			&& idea > 0
			&& (score == -1 || score == 1)
			&& context.getCurrentPhase().equals("discussion")
			) {

			Thumb thumb = new Thumb(score,user,discuss);
	        
			thumbDAO.save(thumb);
			
			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			Idea ideaBean = ideaDAO.findById(idea);

	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("scoreBean", thumb);
	        request.getSession().setAttribute("ideaBean", ideaBean);
	        request.getRequestDispatcher("/admin/scores/addScoreResult.jsp").forward(request, response);
			
		}
		String idUser = request.getParameter("idUser");
		request.setAttribute("id", idUser);
		request.setAttribute("error","Erreur : Vous n'avez pas respecté les contraintes des champs");
		doGet(request, response);
	}

}
