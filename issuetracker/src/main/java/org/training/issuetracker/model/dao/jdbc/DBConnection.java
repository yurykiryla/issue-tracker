/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.training.issuetracker.model.properties.Config;


/**
 * @author Yury
 *
 */
public class DBConnection implements AutoCloseable{
	private Connection connection = null;
	
	private static final String DRIVER_NAME = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DATA_RESOURCE = "jdbc:derby:" + Config.GetConfig().getPath() + "projectdb";
	private static final String CREATE_DB = ";create=true";
	
	
	public DBConnection(){
		try{
			Class.forName(DRIVER_NAME);
			try {
				connection = DriverManager.getConnection(DATA_RESOURCE);
			} catch (SQLException e) {
				try {
					connection = DriverManager.getConnection(DATA_RESOURCE + CREATE_DB);
					Statement statement = connection.createStatement();
					statement.executeUpdate(SQLRequests.CREATE_USERS_TABLE);
					statement.executeUpdate(SQLRequests.CREATE_ISSUES_TABLE);
					statement.executeUpdate(SQLRequests.CREATE_DEFAULT_ADMINISTRATOR);
					statement.executeUpdate(SQLRequests.CREATE_DEFAULT_USER);
					statement.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new IllegalArgumentException(e1);
				}
			}
		}catch(ClassNotFoundException e){
			throw new IllegalArgumentException(e);
		}
	}


	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}


	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws SQLException{
		// TODO Auto-generated method stub
		
	}
	
	
}
