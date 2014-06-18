package org.training.issuetracker.controller.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;


public class ChangeIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public ChangeIssueController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			int issueId = getId(request, Constants.KEY_ISSUE_ID);
			Issue issue = DAOFactory.getIssueDAO().getOb(issueId);
			if (request.getSession().getAttribute(Constants.KEY_USER) == null) {
				request.setAttribute(Constants.KEY_ISSUE, issue);
				forward(Constants.URL_VIEW_ISSUE_PAGE, request, response);
				return;
			}
			issue.setModifyDate(new Date(new java.util.Date().getTime()));
			issue.setModifiedBy((User)request.getSession().getAttribute(Constants.KEY_USER));
			request.setAttribute(Constants.KEY_ISSUE, issue);
			forward(Constants.URL_CHANGE_ISSUE_PAGE, request, response);
		} catch (DAOException e) {
				errorForward(e, request, response);
		}
	}
}