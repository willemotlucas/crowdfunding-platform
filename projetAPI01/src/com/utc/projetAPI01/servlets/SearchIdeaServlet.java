package com.utc.projetAPI01.servlets;

import com.utc.projetAPI01.beans.*;
import com.utc.projetAPI01.dao.IdeaDAOImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchIdeaServlet
 */
@WebServlet("/SearchIdeaServlet")
public class SearchIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		
		List<Idea> results = ideaDAO.findByName(search);
		System.out.println("results size : " + results.size());
		request.setAttribute("results", results);
		
		request.getRequestDispatcher("/user/searchResults.jsp").forward(request, response);
	}

}
