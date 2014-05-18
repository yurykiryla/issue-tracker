package org.training.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

/**
 * Servlet implementation class WelcomePageController
 */
public class WelcomePageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WelcomePageController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(Constants.KEY_USER);
			List<Issue> issues = DAOFactory.getIssuesDAO().getIssues(user, Constants.N_DEFAULT);
			request.setAttribute(Constants.KEY_ISSUES, issues);
			forward(Constants.URL_WELCOM_PAGE, request, response);
		}catch(DAOException e){
			errorForward(e, request, response);
		}
	}
}
