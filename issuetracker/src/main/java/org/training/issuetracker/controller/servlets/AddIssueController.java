package org.training.issuetracker.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;


public class AddIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

	public AddIssueController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Issue issue = new Issue();
			issue.setSummary(request.getParameter(Constants.KEY_SUMMARY));
			issue.setDescription(request.getParameter(Constants.KEY_DESCRIPTION));
			issue.setStatus(DAOFactory.getStatusDAO().getOb(getId(request, Constants.KEY_STATUS)));
			issue.setType(DAOFactory.getTypeDAO().getOb(getId(request, Constants.KEY_TYPE)));
			issue.setPriority(DAOFactory.getPriorityDAO().getOb(getId(request, Constants.KEY_PRIORITY)));
			issue.setProject(DAOFactory.getProjectDAO().getOb(getId(request, Constants.KEY_PROJECT)));
			issue.setBuildFound(DAOFactory.getBuildDAO().getOb(getId(request, Constants.KEY_BUILD_FOUND)));
			issue.setCreatedBy((User) request.getSession().getAttribute(Constants.KEY_USER));
			String assigneeIdStr = request.getParameter(Constants.KEY_ASSIGNEE);
			if (assigneeIdStr != null) {
				issue.setAssignee(DAOFactory.getUserDAO().getOb(Integer.parseInt(assigneeIdStr)));
			}
			DAOFactory.getIssueDAO().addOb(issue);
			request.setAttribute(Constants.KEY_MESSAGE, Constants.MESSAGE_ADD_ISSUE);
			forward(Constants.URL_OPERATION_RESULT_PAGE, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
		
	}
}
