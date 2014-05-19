/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Password;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.UsersDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;
/**
 * @author Yury Kiryla
 *
 */
public class UserJdbcDAO extends JdbcDAO<User> implements UsersDAO {

	/**
	 * 
	 */
	public UserJdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.UsersDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String email, String password) throws DAOException {
		// TODO Auto-generated method stub
		try{
			resultSet = getResultSet(SELECT_USER_BY_EMAIL_1 + email + SELECT_USER_BY_EMAIL_2);
			if(resultSet != null & resultSet.next()){
				User user = getOb(resultSet);
				if(user.getPassword().checkPassword(password)){
					return user;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SELECT_USER_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SELECT_USERS;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected User getOb(ResultSet resultSet) throws DAOException {
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(INDEX_ID);
			String firstName = resultSet.getString(INDEX_FIRST_NAME);
			String lastName = resultSet.getString(INDEX_LAST_NAME);
			String emailAddress = resultSet.getString(INDEX_EMAIL_ADDRESS);
			Role role = Role.valueOf(resultSet.getString(INDEX_ROLE));
			Password password = new Password();
			password.setEncryptedPassword(resultSet.getString(INDEX_PASSWORD));
			return new User(id, firstName, lastName, emailAddress, role, password);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
}
