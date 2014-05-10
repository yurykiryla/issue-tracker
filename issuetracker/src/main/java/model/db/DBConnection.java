/**
 * 
 */
package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.constants.SQLRequests;


/**
 * @author Yury
 *
 */
public class DBConnection {
	private Connection connection;
	private static final String DRIVER_NAME = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DATA_RESOURCE = "jdbc:derby:src/main/resources/projectdb";
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
	
	
}
