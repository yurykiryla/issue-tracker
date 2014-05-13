package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.constants.Constants;
import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.factories.UserFactory;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter(Constants.KEY_LOGIN);
		String password = request.getParameter(Constants.KEY_PASSWORD);
		IUserDAO userDAO = UserFactory.getClassFromFactory();
		User user = userDAO.getUser(email, password);
		request.getSession().setAttribute(Constants.KEY_USER, user);
		getServletContext().getRequestDispatcher(Constants.URL_WELCOM_PAGE_CONTROLLER)
			.forward(request, response);
	}

}
