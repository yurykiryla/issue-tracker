package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.User;
import model.factories.UserFactory;
import model.interfaces.IUserDAO;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("login");
		String password = request.getParameter("password");
		IUserDAO userDAO = UserFactory.getClassFromFactory();
		User user = userDAO.getUser(email, password);
		request.getSession().setAttribute("user", user);
		getServletContext().getRequestDispatcher("/WelcomPageController").forward(request, response);
	}

}
