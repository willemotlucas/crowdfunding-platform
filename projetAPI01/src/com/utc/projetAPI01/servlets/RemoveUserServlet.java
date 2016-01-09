package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Adress;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class RemoveUserServlet
 */
@WebServlet("/RemoveUserServlet")
public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("edit user");

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date;
		try {
			date = (Date) formatter.parse(request.getParameter("date"));
		
        String statut = request.getParameter("statut");
        String type = request.getParameter("type");
        Integer numRue = Integer.parseInt(request.getParameter("num"));
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("cp");
        String ville = request.getParameter("ville");
        Adress adresse = new Adress(numRue,rue,codePostal,ville);
        Utilisateur user = new Utilisateur(email,pwd,nom,prenom,telephone,date,statut,type,adresse);
        
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        userDAO.delete(user);
        request.getSession().setAttribute("userBean", user);
        request.getSession().setAttribute("adressBean", user.getAdress());
        request.getRequestDispatcher("/admin/removeUser.jsp").forward(request, response);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
