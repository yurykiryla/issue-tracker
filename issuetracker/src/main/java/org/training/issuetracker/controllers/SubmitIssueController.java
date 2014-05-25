package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

public class SubmitIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public SubmitIssueController() {
    }

    @Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO<Status> statusDAO = DAOFactory.getStatusDAO();
			Status[] statuses = new Status[2];
			statuses[0] = statusDAO.getOb(Constants.ID_STATUS_NEW);
			statuses[1] = statusDAO.getOb(Constants.ID_STATUS_ASSIGNED);
			request.setAttribute(Constants.KEY_STATUSES, statuses);
			request.setAttribute(Constants.KEY_TYPES, DAOFactory.getTypeDAO().getObs());
			request.setAttribute(Constants.KEY_PRIORITIES, DAOFactory.getPriorityDAO().getObs());
			request.setAttribute(Constants.KEY_PROJECTS, DAOFactory.getProjectDAO().getObs());
			request.setAttribute(Constants.KEY_USERS, DAOFactory.getUserDAO().getObs());
			forward(Constants.URL_SUBMIT_ISSUE_PAGE, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}