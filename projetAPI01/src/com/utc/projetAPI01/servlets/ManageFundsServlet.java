package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class ManageFundingsServlet
 */
@WebServlet("/ManageFundingsServlet")
public class ManageFundsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageFundsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("get all fundings of the application");        
	    MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
	    List<MakeFund> allMakeFunds = makeFundDAO.findAll();

	    System.out.println("allMakeFunds"+allMakeFunds);
	    /*Map<MakeFund,Long> mapFund = new HashMap();
	       
	    Iterator<MakeFund> fundings = allMakeFunds.iterator();
	    while (fundings.hasNext()) {
	    	MakeFund fund = (MakeFund) fundings.next();
	
		    Long total = makeFundDAO.findCollectedAmountByFund(fund.getId());
		    mapFund.put(fund, total);
	    }*/

        request.getSession().setAttribute("allMakeFunds", allMakeFunds);
        request.getRequestDispatcher("/admin/funds/manageFunds.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
