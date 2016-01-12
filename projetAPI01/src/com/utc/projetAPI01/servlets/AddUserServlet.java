package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.AdressDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
        System.out.println("add new user");

        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();

        String email = request.getParameter("email");
        Utilisateur emailUsed = userDAO.findByEmail(email);
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pwd = request.getParameter("password");
        String confPass = request.getParameter("confPass");
        String telephone = request.getParameter("telephone");
        String statut = request.getParameter("statut");
        String type = request.getParameter("type");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        	
		if(!nom.isEmpty() && nom.length() <= 40
			&& !prenom.isEmpty() && prenom.length() <= 40
			&& !pwd.isEmpty() && pwd.length() >= 6 && pwd.length() <= 40
			&& !email.isEmpty()
			&& telephone.length() <= 15
			&& statut.length() <= 10
			&& type.length() <= 20
			&& pwd.equals(confPass)
			&& emailUsed.equals(null)
			) {
    
	        
	        AdressDAOImpl adressDAO = new AdressDAOImpl();

	        Integer numRue = Integer.parseInt(request.getParameter("numRue"));
	        String rue = request.getParameter("rue");
	        String codePostal = request.getParameter("codePostale");
	        String ville = request.getParameter("ville");

	        System.out.println("ville"+ville+"    "+date);
	        if(!rue.isEmpty()
	    			&& !codePostal.isEmpty()
	    			&& !ville.isEmpty() && ville.length() <= 50
	    			&& numRue>0) {


	            Adress adress = new Adress(numRue,rue,codePostal,ville);	            	    	        
	    		adressDAO.save(adress);    	        

	            Utilisateur user = new Utilisateur(email,pwd,nom,prenom,telephone,date,statut,type,adress);  
				userDAO.save(user);
		        request.getSession().setAttribute("userBean", user);
		        request.getSession().setAttribute("adressBean", user.getAdress());
		        request.getRequestDispatcher("/admin/users/addUserResult.jsp").forward(request, response);
	        
	        }
			
		}
		request.setAttribute("error","Erreur : Vous n'avez pas respecté les contraintes des champs");
        request.getRequestDispatcher("/admin/users/addUserForm.jsp").forward(request, response);
	}
}
        
        
        
        
        
        
        
        