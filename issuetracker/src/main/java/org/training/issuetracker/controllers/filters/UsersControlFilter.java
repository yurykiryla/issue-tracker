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

public class UsersControlFilter implements Filter {

	public UsersControlFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		User user = (User)((HttpServletRequest)request).getSession()
									.getAttribute(Constants.KEY_USER);
		if (user == null) {
			((HttpServletResponse)response).sendRedirect(Config.getConfig().getContextPath() 
					+ Constants.URL_WELCOM_PAGE_CONTROLLER);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}