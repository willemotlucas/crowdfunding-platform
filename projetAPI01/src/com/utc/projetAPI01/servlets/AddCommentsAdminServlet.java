package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.CommentsDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class AddCommentsAdmin
 */
@WebServlet("/AddCommentsAdminServlet")
public class AddCommentsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentsAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		UtilisateurDAOImpl utilisateurDao = new UtilisateurDAOImpl();
        List<Utilisateur> allUsers = utilisateurDao.findAll();
        List<Idea> allIdeas = ideaDao.findAll();
        
		request.setAttribute("allIdeas", allIdeas);
		request.setAttribute("allUsers", allUsers);
		request.getRequestDispatcher("/admin/comments/addComments.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
		IdeaDAOImpl ideaDao = new IdeaDAOImpl();
		CommentsDAOImpl commentsDao = new CommentsDAOImpl();
		UtilisateurDAOImpl utilisateurDao = new UtilisateurDAOImpl();

		

		// TODO Auto-generated method stub
		String descriptionComment = request.getParameter("description");
		String utilisateurComment = request.getParameter("utilisateur");
		String ideaComment = request.getParameter("idea");

		
		if(!descriptionComment.isEmpty() && descriptionComment.length() <= 255
			&& !utilisateurComment.isEmpty()
			&& !ideaComment.isEmpty()){
			
			List<Idea> ideas = ideaDao.findByName(ideaComment);
			
			Utilisateur utilisateur = utilisateurDao.findByEmail(utilisateurComment);
			
			Comments comments = new Comments(descriptionComment, new Date() , utilisateur, ideas.get(0));
			
			commentsDao.save(comments);
			
			response.sendRedirect(request.getContextPath() + "/admin/manageComments");
			
		}
	}

}
