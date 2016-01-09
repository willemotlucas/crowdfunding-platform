package com.utc.projetAPI01.servlets;

import java.io.IOException;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("edit user");

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String statut = request.getParameter("statut");
        String type = request.getParameter("type");
        Integer numRue = Integer.parseInt(request.getParameter("numRue"));
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostale");
        String ville = request.getParameter("ville");
        Adress adresse = new Adress(numRue,rue,codePostal,ville);
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findByEmail(email);
        AdressDAOImpl adressDAO = new AdressDAOImpl();
        Adress adress = adressDAO.save(adresse);
        user.setAccountStatus(statut);
        user.setAccountType(type);
        user.setAdress(adress);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setPassword(pwd);
        user.setTelephone(telephone);
        request.getSession().setAttribute("userBean", user);
        request.getSession().setAttribute("adressBean", user.getAdress());
        request.getRequestDispatcher("/editUser.jsp").forward(request, response);
	}

}
