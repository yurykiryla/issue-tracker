/**
 * 
 */
package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yury Kiryla
 *
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		performTask(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		performTask(req, resp);
	}

	abstract protected void  performTask(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
	protected void forward(String url, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
