package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Issue;
import model.beans.User;
import model.constants.Constants;
import model.factories.IssuesFactory;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.KEY_USER);
		List<Issue> issues = IssuesFactory.getClassFromFactory().getIssues(user, Constants.N_DEFAULT);
		request.setAttribute(Constants.KEY_ISSUES, issues);
		forward(Constants.URL_WELCOM_PAGE, request, response);
	}

}
