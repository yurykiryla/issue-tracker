package org.training.issuetracker.controllers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controllers.Constants;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.properties.Config;

/**
 * Servlet Filter implementation class UsersControlFilter
 */
public class UsersControlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UsersControlFilter() {
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
		// place your code here
		
		User user = (User)((HttpServletRequest)request).getSession()
									.getAttribute(Constants.KEY_USER);
		if(user == null){
			((HttpServletResponse)response).sendRedirect(Config.getConfig().getContextPath() + Constants.URL_WELCOM_PAGE_CONTROLLER);
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
