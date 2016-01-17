package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.PhaseContext;
import com.utc.projetAPI01.beans.Redaction;
import com.utc.projetAPI01.dao.CommentsDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.PhaseContextDAOImpl;
import com.utc.projetAPI01.dao.RedactionDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class EditCommentsServlet
 */
@WebServlet("/EditCommentsServlet")
public class EditCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentsServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommentsDAOImpl commentsDao = new CommentsDAOImpl();
		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		UtilisateurDAOImpl utilisateurDao = new UtilisateurDAOImpl();
		int idComments = Integer.parseInt(request.getParameter("id"));
        Comments comments = commentsDao.findById(idComments);
        List<Utilisateur> allUsers = utilisateurDao.findAll();
        List<Idea> allIdeas = ideaDao.findAll();
        
		
		if(comments != null){
			request.setAttribute("comments", comments);
			request.setAttribute("allIdeas", allIdeas);
			request.setAttribute("allUsers", allUsers);
			request.getRequestDispatcher("/admin/comments/editComments.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/admin/manageComments").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		CommentsDAOImpl commentsDao = new CommentsDAOImpl();
		UtilisateurDAOImpl utilisateurDao = new UtilisateurDAOImpl();
		int idComments = Integer.parseInt(request.getParameter("id"));
		Comments comments = commentsDao.findById(idComments);

		// TODO Auto-generated method stub
		String descriptionComment = request.getParameter("description");
		String utilisateurComment = request.getParameter("utilisateur");
		String ideaComment = request.getParameter("idea");

		
		if(!descriptionComment.isEmpty() && descriptionComment.length() <= 255
			&& !utilisateurComment.isEmpty()
			&& !ideaComment.isEmpty()){
			
			List<Idea> ideas = ideaDao.findByName(ideaComment);
			comments.setIdea(ideas.get(0));
			
			Utilisateur utilisateur = utilisateurDao.findByEmail(utilisateurComment);
			comments.setUtilisateur(utilisateur);
			
			comments.setDescription(descriptionComment);
			
			commentsDao.save(comments);
			
			response.sendRedirect(request.getContextPath() + "/admin/manageComments");
			
		}
	}

}
