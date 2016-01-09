package com.utc.projetAPI01.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.UtilisateurDAOImpl;

/**
 * Servlet implementation class EditUsersServlet
 */
@WebServlet("/EditUsersServlet")
public class EditUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsersServlet() {
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        UtilisateurDAOImpl userDAO = new UtilisateurDAOImpl();
        Utilisateur user = userDAO.findById(id);
        request.getSession().setAttribute("userBean", user);
        request.getSession().setAttribute("adressBean", user.getAdress());
        request.getRequestDispatcher("/admin/editUsers.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
