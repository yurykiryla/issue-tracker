package org.training.issuetracker.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Configuration;
import org.training.issuetracker.controller.Constants;


public class LogoutController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public LogoutController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(Configuration.get().getContextPath() + Constants.URL_WELCOM_PAGE_CONTROLLER);
	}

}
