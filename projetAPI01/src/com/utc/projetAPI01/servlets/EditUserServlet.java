package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.AdressDAOImpl;
import com.utc.projetAPI01.dao.IdeaDAOImpl;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("get all users of the application");

        //UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = userDAO.findById(idUser);
		
		if(user != null){
			request.setAttribute("userBean", user);
			request.setAttribute("adressBean", user.getAdress());
			request.getRequestDispatcher("/admin/editUserForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("edit user");
        
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = userDAO.findById(idUser);

        String email = request.getParameter("email");
        Utilisateur emailUsed = userDAO.findByEmail(email);

        Utilisateur userSession = (Utilisateur) request.getSession().getAttribute("userSession");
        String emailSession = userSession.getEmail();
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pwd = request.getParameter("password");
        String confPass = request.getParameter("confPass");
        String telephone = request.getParameter("telephone");
        String statut = request.getParameter("statut");
        String type = request.getParameter("type");
        	
		if(!nom.isEmpty() && nom.length() <= 40
			&& !prenom.isEmpty() && prenom.length() <= 40
			&& !pwd.isEmpty() && pwd.length() >= 6 && pwd.length() <= 40
			&& !email.isEmpty()
			&& telephone.length() <= 15
			&& statut.length() <= 10
			&& type.length() <= 20
			&& pwd == confPass
			&& ((emailSession == email) || emailUsed == null) ) {

	        user.setNom(nom);
	        user.setPrenom(prenom);
	        user.setPassword(email);
	        user.setPassword(pwd);
	        user.setTelephone(telephone);
	        user.setAccountStatus(statut);
	        user.setAccountType(type);
	        
	        
	        AdressDAOImpl adressDAO = new AdressDAOImpl();
	        Adress adress = user.getAdress();

	        Integer numRue = Integer.parseInt(request.getParameter("numRue"));
	        String rue = request.getParameter("rue");
	        String codePostal = request.getParameter("codePostale");
	        String ville = request.getParameter("ville");
	        
	        if(!rue.isEmpty()
	    			&& !codePostal.isEmpty()
	    			&& !ville.isEmpty() && ville.length() <= 50
	    			&& numRue>0) {

	        	adress.setNum(numRue);
	        	adress.setRue(rue);
	        	adress.setCodePostale(codePostal);
	    	    adress.setVille(ville);
	    	        
	    		adressDAO.save(adress);    			
	    	}	        

	        user.setAdress(adress);
	        
			userDAO.save(user);
	        request.getSession().setAttribute("userBean", user);
	        request.getSession().setAttribute("adressBean", user.getAdress());
	        request.getRequestDispatcher("/admin/editUserResult.jsp").forward(request, response);
			
		}
	}
		

}
