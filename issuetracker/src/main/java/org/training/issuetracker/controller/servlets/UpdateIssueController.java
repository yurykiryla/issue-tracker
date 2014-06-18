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


public class UpdateIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

  public UpdateIssueController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			int statusId = getId(request, Constants.KEY_STATUS);
			int id = getId(request, Constants.KEY_ID);
			Issue issue = DAOFactory.getIssueDAO().getOb(id);
			issue.setModifiedBy((User)request.getSession().getAttribute(Constants.KEY_USER));
			if (statusId == Constants.ID_STATUS_REOPENED) {
				issue.setStatus(DAOFactory.getStatusDAO().getOb(Constants.ID_STATUS_NEW));
				issue.setAssignee(null);
			} else {
				issue.setSummary(request.getParameter(Constants.KEY_SUMMARY));
				issue.setDescription(request.getParameter(Constants.KEY_DESCRIPTION));
				issue.setStatus(DAOFactory.getStatusDAO().getOb(statusId));
				if (statusId == Constants.ID_STATUS_CLOSED || statusId == Constants.ID_STATUS_RESOLVED){
					issue.setResolution(DAOFactory.getResolutionDAO().getOb(getId(request, Constants.KEY_RESOLUTION)));
				}
				issue.setType(DAOFactory.getTypeDAO().getOb(getId(request, Constants.KEY_TYPE)));
				issue.setPriority(DAOFactory.getPriorityDAO().getOb(getId(request, Constants.KEY_PRIORITY)));
				issue.setProject(DAOFactory.getProjectDAO().getOb(getId(request, Constants.KEY_PROJECT)));
				issue.setBuildFound(DAOFactory.getBuildDAO().getOb(getId(request, Constants.KEY_BUILD_FOUND)));
				if (statusId != Constants.ID_STATUS_NEW){
					issue.setAssignee(DAOFactory.getUserDAO().getOb(getId(request, Constants.KEY_ASSIGNEE)));
				}
			}
			DAOFactory.getIssueDAO().changeOb(issue);
			request.setAttribute(Constants.KEY_MESSAGE, Constants.MESSAGE_CHANGE_ISSUE);
			forward(Constants.URL_OPERATION_RESULT_PAGE, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}