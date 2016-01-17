package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;

/**
 * Servlet implementation class SeeScoreServlet
 */
@WebServlet("/SeeScoreServlet")
public class SeeScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("see score");
		
		
		ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
		int idThumb = Integer.parseInt(request.getParameter("id"));
        Thumb thumb = thumbDAO.findById(idThumb);
        
		if(thumb != null){
			request.setAttribute("scoreBean", thumb);
			request.setAttribute("userBean", thumb.getUtilisateur());
			request.setAttribute("ideaBean", thumb.getDiscussion().getContext().getIdea());
			request.getRequestDispatcher("/admin/scores/seeScore.jsp").forward(request, response);
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
