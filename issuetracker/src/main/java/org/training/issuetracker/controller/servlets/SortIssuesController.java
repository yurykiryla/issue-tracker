package org.training.issuetracker.controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Configuration;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;


public class SortIssuesController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public SortIssuesController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String key = request.getParameter(Constants.KEY_SORT);
			List<Issue> issues = DAOFactory.getIssueDAO().getSortedIssues((User)request.getSession().getAttribute(Constants.KEY_USER), Configuration.get().getN(), key);
			request.setAttribute(Constants.KEY_ISSUES, issues);
			forward(Constants.URL_WELCOM_PAGE, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}