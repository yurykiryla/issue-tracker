package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import interfaces.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WebPagesParts;

/**
 * Servlet implementation class WelcomPageController
 */
@WebServlet("/WelcomPageController")
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
		PrintWriter writer = response.getWriter();
		writer.println(WebPagesParts.getPageHead("Welcom page / Dashboard"));
		writer.println(WebPagesParts.getPageEnd());
	}

}
