package org.training.issuetracker.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.Configuration;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.bean.User;


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
			((HttpServletResponse)response).sendRedirect(Configuration.get().getContextPath() 
					+ Constants.URL_WELCOM_PAGE_CONTROLLER);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}