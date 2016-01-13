package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class RemoveFundServlet
 */
@WebServlet("/RemoveFundServlet")
public class RemoveFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("remove fund");

        MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        MakeFund makeFund = makeFundDAO.findById(id);
        makeFundDAO.delete(makeFund);
        request.getSession().setAttribute("userBean", makeFund.getUtilisateur());
        request.getSession().setAttribute("makeFundBean", makeFund);
        request.getSession().setAttribute("ideaBean", makeFund.getFund().getContext().getIdea());
        request.getRequestDispatcher("/admin/funds/removeFund.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
