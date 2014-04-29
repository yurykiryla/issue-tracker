package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.User;
import model.webelements.WebPagesParts;

/**
 * Servlet implementation class WelcomPageController
 */
public class WelcomPageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WelcomPageController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		writer.println(WebPagesParts.getPageHead("Welcom page / Dashboard"));
		User user = (User) session.getAttribute("user");
		writer.println(WebPagesParts.getUserMenu(user));
		writer.println(WebPagesParts.getIssuesList(user));
		writer.println(WebPagesParts.getPageEnd());
	}

}
