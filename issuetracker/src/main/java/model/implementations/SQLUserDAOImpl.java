/**
 * 
 */
package model.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.beans.User;
import model.constants.Constants;
import model.constants.Role;
import model.constants.SQLRequests;
import model.db.DBConnection;
import model.interfaces.IUserDAO;

/**
 * @author Yury
 *
 */
public class SQLUserDAOImpl implements IUserDAO {

	/* (non-Javadoc)
	 * @see model.interfaces.IUserDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String email, String password) {
		// TODO Auto-generated method stub
		return getUser(SQLRequests.SELECT_USER_BY_EMAIL_PASSWORD_1 + email + SQLRequests.SELECT_USER_BY_EMAIL_PASSWORD_2 + password + SQLRequests.SELECT_USER_BY_EMAIL_PASSWORD_3);
	}

	/* (non-Javadoc)
	 * @see model.interfaces.IUserDAO#getUser(int)
	 */
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return getUser(SQLRequests.SELECT_USER_BY_ID + id);
	}

	private User getUser(String sqlRequest){
		User user = null;
		try(DBConnection dbConnection = new DBConnection()){
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sqlRequest);
			if(resultSet.next()){
				int id = resultSet.getInt(Constants.INDEX_ID);
				String firstName = resultSet.getString(Constants.INDEX_FIRST_NAME);
				String lastName = resultSet.getString(Constants.INDEX_LAST_NAME);
				Role role = Role.valueOf(resultSet.getString(Constants.INDEX_ROLE));
				String email = resultSet.getString(Constants.INDEX_EMAIL_ADDRESS);
				user = new User(id, firstName, lastName, email, role);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		return user;
		
	}
}
