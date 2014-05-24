package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.UsersDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter(Constants.KEY_EMAIL);
			String password = request.getParameter(Constants.KEY_PASSWORD);
			UsersDAO userDAO = DAOFactory.getUsersDAO();
			User user = userDAO.getUser(email, password);
			request.getSession().setAttribute(Constants.KEY_USER, user);
			forward(Constants.URL_WELCOM_PAGE_CONTROLLER, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}