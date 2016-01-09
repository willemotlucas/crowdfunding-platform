package com.utc.projetAPI01.servlets;

import com.utc.projetAPI01.beans.*;
import com.utc.projetAPI01.dao.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadUserHomepage
 */
@WebServlet("/LoadUserHomepage")
public class LoadUserHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUserHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		FundDAOImpl fundDAO = new FundDAOImpl();
		
		List<Idea> Last3IdeasProposed = ideaDAO.findByLastProposed();
		List<Fund> Last3IdeasInFunding = fundDAO.find3Last();
		
		request.setAttribute("last3ideasProposed", Last3IdeasProposed);
		request.setAttribute("last3IdeasInFunding", Last3IdeasInFunding);
		
		request.getRequestDispatcher("/user/homeUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
