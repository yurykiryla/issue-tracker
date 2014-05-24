package org.training.issuetracker.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

/**
 * Servlet implementation class AddIssueController
 */
public class AddIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddIssueController() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractController#performTask(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String summary = request.getParameter(Constants.KEY_SUMMARY);
			String description = request.getParameter(Constants.KEY_DESCRIPTION);
			Status status = DAOFactory.getStatusDAO().getOb(Integer.parseInt(request.getParameter(Constants.KEY_STATUS)));
			Type type = DAOFactory.getTypeDAO().getOb(Integer.parseInt(request.getParameter(Constants.KEY_TYPE)));
			Priority priority = DAOFactory.getPriorityDAO().getOb(Integer.parseInt(request.getParameter(Constants.KEY_PRIORITY)));
			Project project = DAOFactory.getProjectDAO().getOb(Integer.parseInt(request.getParameter(Constants.KEY_PROJECT)));
			Build buildFound = DAOFactory.getBuildDAO().getOb(Integer.parseInt(request.getParameter(Constants.KEY_BUILD_FOUND)));
			Date createdDate = new Date(new java.util.Date().getTime());
			User createdBy = (User)request.getSession().getAttribute(Constants.KEY_USER);
			User assignee = null;
			String assigneeIdStr = request.getParameter(Constants.KEY_ASSIGNEE);
			if(assigneeIdStr != null){
				assignee = DAOFactory.getUserDAO().getOb(Integer.parseInt(assigneeIdStr));
			}
			Issue issue = new Issue(priority, assignee, type, status, summary, description, project, buildFound, createdDate, createdBy);
			DAOFactory.getIssueDAO().addOb(issue);
			forward(Constants.URL_WELCOM_PAGE_CONTROLLER, request, response);
		}catch(DAOException e){
			e.printStackTrace();
			errorForward(e, request, response);
		}
		
	}

}
