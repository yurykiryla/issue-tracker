package org.training.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;
import org.training.issuetracker.model.properties.Config;

public class SortIssuesController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public SortIssuesController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String key = request.getParameter(Constants.KEY_SORT);
			List<Issue> issues = DAOFactory.getIssuesDAO().getSortedIssues((User)request.getSession().getAttribute(Constants.KEY_USER), Config.getConfig().getN(), key);
			request.setAttribute(Constants.KEY_ISSUES, issues);
			forward(Constants.URL_WELCOM_PAGE, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}