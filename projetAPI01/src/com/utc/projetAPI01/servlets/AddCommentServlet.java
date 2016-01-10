package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.AddressDAOImpl;
import com.utc.projetAPI01.dao.CommentsDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String content = request.getParameter("comment");
		int idIdea = Integer.parseInt(request.getParameter("idIdea"));
		
		if(!content.isEmpty() && content.length() >= 2 && content.length() <= 255){
			CommentsDAOImpl commentsDAO = new CommentsDAOImpl();
			IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
			
			Idea currentIdea = ideaDAO.findById(idIdea);
			Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute("userSession");
			
			Comments comment = new Comments(content, new Date(), currentUser, currentIdea);
			try{
				commentsDAO.save(comment);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
				
		response.sendRedirect(request.getContextPath() + "/user/ideaDetails?id=" + idIdea);
	}

}
