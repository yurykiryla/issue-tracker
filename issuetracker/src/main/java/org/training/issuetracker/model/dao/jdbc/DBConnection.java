/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.properties.Config;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

/**
 * @author Yury
 *
 */
public class DBConnection implements AutoCloseable{
	private Connection connection = null;
	private Statement statement = null;
	
	private static final String DRIVER_NAME = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DATA_RESOURCE = "jdbc:derby:" + Config.getConfig().getPath() + "projectdb";
	private static final String CREATE_DB = ";create=true";
	
	
	public DBConnection() throws DAOException{
		try{
			Class.forName(DRIVER_NAME);
			try {
				connection = DriverManager.getConnection(DATA_RESOURCE);
				statement = connection.createStatement();
			} catch (SQLException e) {
				try {
					connection = DriverManager.getConnection(DATA_RESOURCE + CREATE_DB);
					statement = connection.createStatement();
					
					statement.executeUpdate(CREATE_ISSUES_TABLE);
					
					statement.executeUpdate(CREATE_PRIORITIES_TABLE);
					statement.executeUpdate(CREATE_PRIORITY_CRITICAL);
					statement.executeUpdate(CREATE_PRIORITY_MAJOR);
					statement.executeUpdate(CREATE_PRIORITY_IMPORTANT);
					statement.executeUpdate(CREATE_PRIORITY_MINOR);
					
					statement.executeUpdate(CREATE_PROJECTS_TABLE);
					statement.executeUpdate(CREATE_DEFAULT_PROJECT);
					statement.executeUpdate(CREATE_BUILDS_TABLE);
					statement.executeUpdate(CREATE_DEFAULT_BUILD);
					
					statement.executeUpdate(CREATE_RESOLUTIONS_TABLE);
					statement.executeUpdate(CREATE_RESOLUTION_FIXED);
					statement.executeUpdate(CREATE_RESOLUTION_INVALID);
					statement.executeUpdate(CREATE_RESOLUTION_WONTFIX);
					statement.executeUpdate(CREATE_RESOLUTION_WORKSFORME);
					
					statement.executeUpdate(CREATE_STATUSES_TABLE);
					statement.executeUpdate(CREATE_STATUS_NEW);
					statement.executeUpdate(CREATE_STATUS_ASSIGNED);
					statement.executeUpdate(CREATE_STATUS_IN_PROGRESS);
					statement.executeUpdate(CREATE_STATUS_RESOLVED);
					statement.executeUpdate(CREATE_STATUS_CLOSED);
					statement.executeUpdate(CREATE_STATUS_REOPENED);
					
					statement.executeUpdate(CREATE_TYPES_TABLE);
					statement.executeUpdate(CREATE_TYPE_COSMETIC);
					statement.executeUpdate(CREATE_TYPE_BUG);
					statement.executeUpdate(CREATE_TYPE_FEATURE);
					statement.executeUpdate(CREATE_TYPE_PERFOMANCE);
																	
					statement.executeUpdate(CREATE_USERS_TABLE);
					statement.executeUpdate(CREATE_DEFAULT_ADMINISTRATOR);
					statement.executeUpdate(CREATE_DEFAULT_USER);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new DAOException(e1);
				}
			}
		}catch(ClassNotFoundException e){
			throw new DAOException(e);
		}
	}


	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}


	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}


	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws DAOException{
		// TODO Auto-generated method stub
		try {
			if(statement != null){
				statement.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException();
		}
	}
}
