package org.training.issuetracker.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

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
			request.setAttribute(Constants.KEY_STATUSES, DAOFactory.getStatusDAO().getObs());
			request.setAttribute(Constants.KEY_RESOLUTIONS, DAOFactory.getResolutionDAO().getObs());
			request.setAttribute(Constants.KEY_TYPES, DAOFactory.getTypeDAO().getObs());
			request.setAttribute(Constants.KEY_PRIORITIES, DAOFactory.getPriorityDAO().getObs());
			request.setAttribute(Constants.KEY_PROJECTS, DAOFactory.getProjectDAO().getObs());
			request.setAttribute(Constants.KEY_USERS, DAOFactory.getUserDAO().getObs());
			forward(Constants.URL_CHANGE_ISSUE_PAGE, request, response);
		} catch (DAOException e) {
				errorForward(e, request, response);
		}
	}
}