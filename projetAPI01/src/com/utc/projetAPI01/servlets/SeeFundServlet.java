package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;

/**
 * Servlet implementation class SeeFundServlet
 */
@WebServlet("/SeeFundServlet")
public class SeeFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("see fund");
		
		MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
		int idFund = Integer.parseInt(request.getParameter("id"));
        MakeFund makeFund = makeFundDAO.findById(idFund);
        
		if(makeFund != null){
			request.setAttribute("makeFundBean", makeFund);
			request.setAttribute("userBean", makeFund.getUtilisateur());
			request.setAttribute("ideaBean", makeFund.getFund().getContext().getIdea());
			request.getRequestDispatcher("/admin/funds/seeFund.jsp").forward(request, response);
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
