package com.utc.projetAPI01.servlets;

import com.utc.projetAPI01.beans.*;
import com.utc.projetAPI01.dao.*;

import java.util.Iterator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
		CommentsDAOImpl commentsDAO = new CommentsDAOImpl();
		PhaseContextDAOImpl contextDAO = new PhaseContextDAOImpl();
		
		List<Idea> Last3IdeasProposed = ideaDAO.findByLastProposed();
		List<Fund> Last3IdeasInFunding = fundDAO.find3Last();
		Map<Fund, Integer> Last3IdeasInFundingWithPercentage = new HashMap();

		Iterator<Fund> it = Last3IdeasInFunding.iterator();
		while(it.hasNext()){
			Fund fund = it.next();
			int amountCollected = makeFundDAO.findCollectedAmountByFund(fund.getId()).intValue();
			int currentFund = fund.getContext().getIdea().getFundingRequested();
			Double percentage2 = new Double((double)amountCollected/currentFund*100);
			int percentage = percentage2.intValue();
			Last3IdeasInFundingWithPercentage.put(fund, percentage);
		}
		
		Idea mostPopular = ideaDAO.findByMaxComments();
		int nbComments = commentsDAO.findNbCommentsByIdea(mostPopular.getId());
		PhaseContext mostPopularContext  = contextDAO.findByIdea(mostPopular.getId());
		
		request.setAttribute("last3ideasProposed", Last3IdeasProposed);
		request.setAttribute("last3IdeasInFunding", Last3IdeasInFundingWithPercentage);
		request.setAttribute("mostPopular", mostPopular);
		request.setAttribute("nbCommentsMostPopular", nbComments);
		request.setAttribute("mostPopularContext", mostPopularContext);

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
