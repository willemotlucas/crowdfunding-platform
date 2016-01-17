package com.utc.projetAPI01.servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class DeleteCommentsServlet
 */
@WebServlet("/DeleteCommentsServlet")
public class DeleteCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommentsDAOImpl commentsDao = new CommentsDAOImpl();

		int idComment = Integer.parseInt(request.getParameter("id"));
		Comments comment = commentsDao.findById(idComment);
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
		if(currentUser.getAccountType().equals("normalUser") && comment.getUtilisateur() == currentUser){ //If the current user is the owner of the idea, he may delete it
			if(comment != null)
			{
				commentsDao.delete(comment);
			}
			
		}
		else if(currentUser.getAccountType().equals("admin"))
		{
			if(comment != null)
			{
				commentsDao.delete(comment);
			}
			response.sendRedirect(request.getContextPath() + "/admin/manageComments");
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
