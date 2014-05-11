package model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.implementations.SQLIssueDAOImpl;
import model.implementations.SQLUserDAOImpl;
import model.interfaces.IIssueDAO;
import model.interfaces.IUserDAO;

public class DBTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1) + ";" + resultSet.getString(2));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IUserDAO dao = new SQLUserDAOImpl();
		System.out.println(dao.getUser(1));
		System.out.println(dao.getUser("user", "user"));
		
		
		
		IIssueDAO issueDAO = new SQLIssueDAOImpl();
		System.out.println(issueDAO.getIssues(null, 5));
		System.out.println(issueDAO.getIssues(dao.getUser("user", "user"), 5));
	}

}
