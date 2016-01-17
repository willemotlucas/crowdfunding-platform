package com.utc.projetAPI01.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class connexion
 */
@WebServlet("/Connexion")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");

		
		if(email.isEmpty() || password.isEmpty())
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else
		{
			UtilisateurDAOImpl userDao = new UtilisateurDAOImpl();
			Utilisateur user = userDao.findByEmail(email);
			if(user != null){
				System.out.println("enregistrement user en session");
				request.getSession().setAttribute("userSession", user);
			}

			if(user != null && user.getPassword().equals(password)){
				if(user.getAccountType().equals("admin")){
					System.out.println("redirection vers admin");
					response.sendRedirect(request.getContextPath() + "/admin/homepage");
				}
				else{
					System.out.println("redirection vers normal user");
					response.sendRedirect(request.getContextPath() + "/user/homepage");
					//request.getRequestDispatcher("/user/homeUser.jsp").forward(request, response);
				}
			}
			else{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				System.out.println("redirection vers index");
			}
		}
		
		
	}

}
