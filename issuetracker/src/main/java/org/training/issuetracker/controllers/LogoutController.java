package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.properties.Config;

public class LogoutController extends AbstractController {
	private static final long serialVersionUID = 1L;

    public LogoutController() {
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(Config.getConfig().getContextPath() + Constants.URL_WELCOM_PAGE_CONTROLLER);
	}

}
