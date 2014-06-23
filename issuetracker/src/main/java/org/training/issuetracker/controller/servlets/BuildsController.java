package org.training.issuetracker.controller.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;

import com.google.gson.Gson;


public class BuildsController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = getId(request, Constants.KEY_PROJECT);
		try {
			Project project = DAOFactory.getProjectDAO().getOb(id);
			Map<Integer, String> builds = new HashMap<Integer, String>();
			for (Build build : project.getBuilds()) {
				builds.put(build.getId(), build.getName());
			}
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(builds));
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
		
	}
}
