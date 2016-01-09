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
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
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
        System.out.println("get new user");

        //UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        //Integer id = Integer.parseInt(request.getParameter("id"));
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String statut = "actif";
        String type = "admin";
        Integer numRue = Integer.parseInt(request.getParameter("numRue"));
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostale");
        String ville = request.getParameter("ville");
        System.out.println("les param"+email+pwd+numRue+nom+date+ville);
        Adress adresse = new Adress(numRue,rue,codePostal,ville);
        Utilisateur user = new Utilisateur(email,pwd,nom,prenom,telephone,date,statut,type,adresse);
        userDAO.save(user);
        request.getSession().setAttribute("userBean", user);
        request.getSession().setAttribute("adressBean", user.getAdress());
        request.getRequestDispatcher("/newUser.jsp").forward(request, response);
		
	}
}
