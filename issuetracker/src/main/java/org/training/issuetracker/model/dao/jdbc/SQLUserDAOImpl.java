/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;


/**
 * @author Yury
 *
 */
public class SQLUserDAOImpl implements IUserDAO {

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IUserDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String email, String password) throws DAOException{
		// TODO Auto-generated method stub
		return getUser(SQLRequests.SELECT_USER_BY_EMAIL_PASSWORD_1 + email + SQLRequests.SELECT_USER_BY_EMAIL_PASSWORD_2 + password + SQLRequests.SELECT_USER_BY_EMAIL_PASSWORD_3);
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IUserDAO#getUser(int)
	 */
	@Override
	public User getUser(int id) throws DAOException{
		// TODO Auto-generated method stub
		return getUser(SQLRequests.SELECT_USER_BY_ID + id);
	}

	private User getUser(String sqlRequest) throws DAOException{
		User user = null;
		try(DBConnection dbConnection = new DBConnection()){
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sqlRequest);
			if(resultSet.next()){
				int id = resultSet.getInt(INDEX_ID);
				String firstName = resultSet.getString(INDEX_FIRST_NAME);
				String lastName = resultSet.getString(INDEX_LAST_NAME);
				Role role = Role.valueOf(resultSet.getString(INDEX_ROLE));
				String email = resultSet.getString(INDEX_EMAIL_ADDRESS);
				user = new User(id, firstName, lastName, email, role);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		return user;
		
	}
}
