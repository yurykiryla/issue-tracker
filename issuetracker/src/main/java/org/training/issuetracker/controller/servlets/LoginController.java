package org.training.issuetracker.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;


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
			UserDAO userDAO = DAOFactory.getUserDAO();
			User user = userDAO.getUser(email, password);
			request.getSession().setAttribute(Constants.KEY_USER, user);
			forward(Constants.URL_WELCOM_PAGE_CONTROLLER, request, response);
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
	}
}