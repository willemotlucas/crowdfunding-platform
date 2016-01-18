package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Discussion;
import com.utc.projetAPI01.beans.Fund;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.DiscussionDAOImpl;
import com.utc.projetAPI01.dao.FundDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class EditScoreServlet
 */
@WebServlet("/EditScoreServlet")
public class EditScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
		int idThumb = Integer.parseInt(request.getParameter("id"));
        Thumb thumb = thumbDAO.findById(idThumb);

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        List<Utilisateur> allUsers = userDAO.findAll();

        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> allIdeas = ideaDAO.findAll();
        
		if(thumb != null){
			request.setAttribute("allUsers", allUsers);
			request.setAttribute("allIdeas", allIdeas);
			request.setAttribute("scoreBean", thumb);
			request.setAttribute("userBean", thumb.getUtilisateur());
			request.setAttribute("ideaBean", thumb.getDiscussion().getContext().getIdea());
			request.getRequestDispatcher("/admin/scores/editScoreForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("edit score");

		ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
		int idThumb = Integer.parseInt(request.getParameter("id"));
        Thumb thumb = thumbDAO.findById(idThumb);

        String utilisateur = request.getParameter("utilisateur");
        int idea = Integer.parseInt(request.getParameter("idIdea"));
        int score = Integer.parseInt(request.getParameter("score"));

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findByEmail(utilisateur);

		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		PhaseContext context = contextDAO.findByIdea(idea);

		DiscussionDAOImpl discussDAO = new DiscussionDAOImpl();
		Discussion discuss = discussDAO.findByContext(context.getId());
		/*
		if(thumbDAO.findByUserAndDiscussion(user, discuss.getId()) != null){
			request.setAttribute("error","Cet utilisateur a déjà voté pour cette idée");
			doGet(request, response);
		}
		else */
		if(!utilisateur.isEmpty()
			&& idea > 0
			&& (score == -1 || score == 1)
			) {

			thumb.setDiscussion(discuss);
			thumb.setScore(score);
			thumb.setUtilisateur(user);
	        
			thumbDAO.save(thumb);
			
			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			Idea ideaBean = ideaDAO.findById(idea);

	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("scoreBean", thumb);
	        request.getSession().setAttribute("ideaBean", ideaBean);
	        request.getRequestDispatcher("/admin/scores/editScoreResult.jsp").forward(request, response);
			
		}
		else {
			String idUser = request.getParameter("idUser");
			request.setAttribute("id", idUser);
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			request.setAttribute("error","Erreur : Vous n'avez pas respecté les contraintes des champs");
			doGet(request, response);
		}
	}

}
