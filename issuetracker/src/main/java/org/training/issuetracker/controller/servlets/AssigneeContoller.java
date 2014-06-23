package org.training.issuetracker.controller.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controller.AbstractController;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;

import com.google.gson.Gson;


public class AssigneeContoller extends AbstractController {
	private static final long serialVersionUID = 1L;

	public AssigneeContoller() {
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<User> users = DAOFactory.getUserDAO().getObs();
			
			Map<Integer, String> usersMap = new HashMap<Integer, String>();
			for (User user : users) {
				usersMap.put(user.getId(), user.toString());
			}
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(usersMap));
		} catch (DAOException e) {
			errorForward(e, request, response);
		}
		
	}
	
	

}
