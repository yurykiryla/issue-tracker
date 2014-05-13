package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.constants.Constants;

/**
 * Servlet implementation class LogoutController
 */
public class LogoutController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutController() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractController#performTask(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		response.sendRedirect(Constants.URL1_WELCOM_PAGE_CONTROLLER);
	}

}
