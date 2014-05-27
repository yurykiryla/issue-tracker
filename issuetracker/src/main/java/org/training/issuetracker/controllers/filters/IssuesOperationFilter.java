package org.training.issuetracker.controllers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.training.issuetracker.controllers.Constants;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

public class IssuesOperationFilter implements Filter {

    public IssuesOperationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			request.setAttribute(Constants.KEY_STATUSES, DAOFactory.getStatusDAO().getObs());
			request.setAttribute(Constants.KEY_RESOLUTIONS, DAOFactory.getResolutionDAO().getObs());
			request.setAttribute(Constants.KEY_TYPES, DAOFactory.getTypeDAO().getObs());
			request.setAttribute(Constants.KEY_PRIORITIES, DAOFactory.getPriorityDAO().getObs());
			request.setAttribute(Constants.KEY_PROJECTS, DAOFactory.getProjectDAO().getObs());
			request.setAttribute(Constants.KEY_USERS, DAOFactory.getUserDAO().getObs());
		} catch (DAOException e) {
			request.setAttribute(Constants.KEY_ERROR, e.getMessage());
			request.getRequestDispatcher(Constants.URL_ERROR_PAGE).forward(request, response);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}