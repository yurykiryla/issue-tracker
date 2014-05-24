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
			statuses[0] = statusDAO.getOb(1);
			statuses[1] = statusDAO.getOb(2);
			request.setAttribute("statuses", statuses);
			request.setAttribute("types", DAOFactory.getTypeDAO().getObs());
			request.setAttribute("priorities", DAOFactory.getPriorityDAO().getObs());
			request.setAttribute("projects", DAOFactory.getProjectDAO().getObs());
			request.setAttribute("users", DAOFactory.getUserDAO().getObs());
			forward(Constants.URL_SUBMIT_ISSUE_PAGE, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}