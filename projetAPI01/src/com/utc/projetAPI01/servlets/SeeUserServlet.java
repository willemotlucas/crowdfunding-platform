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

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Comments;
import com.utc.projetAPI01.beans.EvaluationScore;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.MakeFund;
import com.utc.projetAPI01.beans.Thumb;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.AdressDAOImpl;
import com.utc.projetAPI01.dao.CommentsDAOImpl;
import com.utc.projetAPI01.dao.EvaluationScoreDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.MakeFundDAOImpl;
import com.utc.projetAPI01.dao.ThumbDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class SeeUserServlet
 */
@WebServlet("/SeeUserServlet")
public class SeeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("see user");       
	    

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = userDAO.findById(idUser);
        request.getSession().setAttribute("userBean", user);
        request.getSession().setAttribute("adressBean", user.getAdress());
	        
        IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
        List<Idea> userIdeas = ideaDAO.findByCreator(user);
        request.setAttribute("userIdeas", userIdeas);
        
	    CommentsDAOImpl commentsDAO = new CommentsDAOImpl();
	    List<Comments> userComments = commentsDAO.findByUser(user);
        request.setAttribute("userComments", userComments);
        
	    ThumbDAOImpl thumbDAO = new ThumbDAOImpl();
	    List<Thumb> userThumbs = thumbDAO.findByUser(user);
        request.setAttribute("userThumbs", userThumbs);
        
        
	    EvaluationScoreDAOImpl evalDAO = new EvaluationScoreDAOImpl();
	    List<EvaluationScore> userEvals = evalDAO.findByUser(user);
        request.setAttribute("userEvals", userEvals);
        
        
	    MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
	    List<MakeFund> userFunds = makeFundDAO.findByUser(user);
        request.setAttribute("userFunds", userFunds);
        
	        
	        
        request.getRequestDispatcher("/admin/users/seeUser.jsp").forward(request, response);
			
	    
	    
	    
	    /*
	    MakeFundDAOImpl makeFundDAO = new MakeFundDAOImpl();
	    List<MakeFund> allMakeFunds = makeFundDAO.findAll();

	    Map<MakeFund,Long> mapFund = new HashMap();
	       
	    Iterator<MakeFund> fundings = allMakeFunds.iterator();
	    while (fundings.hasNext()) {
	    	MakeFund fund = (MakeFund) fundings.next();
	
		    Long total = makeFundDAO.findCollectedAmountByFund(fund.getId());
		    mapFund.put(fund, total);
	    }

        request.getSession().setAttribute("mapFund", mapFund);
        
        
						<tbody>
							<c:forEach var="entry" items="${sessionScope.mapFund}">
								<tr>
				                    <td>${entry.key.fund.id}</td>
				                    <td>${entry.key.utilisateur.nom}</td>
				                    <td>${entry.key.fund.context.idea.name}</td>
				                    <td>${entry.value}</td>
									<td><a href="/projetAPI01/admin/editFund?id=${user.id}" class="btn btn-success" role="button">Voir</a></td>
									<td><a href="/projetAPI01/admin/editFund?id=${user.id}" class="btn btn-primary" role="button">Modifier</a></td>
									<td><a href="/projetAPI01/admin/removeFund?id=${user.id}" class="btn btn-danger" role="button">Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
	     */
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
