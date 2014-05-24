package org.training.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.issues.sort.SortIssues;

/**
 * Servlet implementation class SortIssuesController
 */
public class SortIssuesController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SortIssuesController() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractController#performTask(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = request.getParameter(Constants.KEY_SORT);
		List<Issue> issues = SortIssues.getSortedList(key);
		request.setAttribute(Constants.KEY_ISSUES, issues);
		forward(Constants.URL_WELCOM_PAGE, request, response);
	}

}
