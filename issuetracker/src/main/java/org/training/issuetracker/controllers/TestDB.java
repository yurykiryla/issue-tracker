package org.training.issuetracker.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.jdbc.DBConnection;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	
	

    /**
     * Default constructor. 
     */
    public TestDB() {
        // TODO Auto-generated constructor stub
    }



	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractController#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		try (DBConnection dbConnection = new DBConnection()) {
			out.println("Hello\n");
		} catch (SQLException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractController#performTask(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}


}
