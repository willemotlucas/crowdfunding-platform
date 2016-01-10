package com.utc.projetAPI01.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.projetAPI01.beans.Idea;
import com.utc.projetAPI01.beans.Utilisateur;
import com.utc.projetAPI01.dao.IdeaDAOImpl;

/**
 * Servlet Filter implementation class EditIdeaFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/user/idea/edit" })
public class EditIdeaFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EditIdeaFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Utilisateur currentUser = (Utilisateur) req.getSession().getAttribute("userSession");
		if(currentUser == null)
			resp.sendRedirect(req.getContextPath());

		int idIdea = Integer.parseInt(request.getParameter("id"));
		IdeaDAOImpl ideaDAO = new IdeaDAOImpl();
		Idea idea = ideaDAO.findById(idIdea);
		//We check if the idea's id receive in the parameter have been created by the current user. 
		//If yes, he mays edit it. If not, it is not his idea and he may not edit it.
		if( idea != null && idea.getMadeBy().getId() == currentUser.getId()){
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/user/ideas/proposed");	
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
