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
	private static final String DATA_RESOURCE = "jdbc:derby:" + Config.getConfig().getPath() 
			+ "projectdb";
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
					statement.executeUpdate(CREATE_USERS_TABLE);
					statement.executeUpdate(CREATE_ISSUES_TABLE);
					statement.executeUpdate(CREATE_DEFAULT_ADMINISTRATOR);
					statement.executeUpdate(CREATE_DEFAULT_USER);
					statement.executeUpdate(CREATE_BUILDS_TABLE);
					statement.executeUpdate(CREATE_PROJECTS_TABLE);
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
