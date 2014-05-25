package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Password;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.UsersDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class UserJdbcDAO extends JdbcDAO<User> implements UsersDAO {

	public UserJdbcDAO() {
	}

	@Override
	public User getUser(String email, String password) throws DAOException {
		try {
			resultSet = getResultSet(SELECT_USER_BY_EMAIL_1 + email + SELECT_USER_BY_EMAIL_2);
			if(resultSet != null & resultSet.next()){
				User user = getOb(resultSet);
				if(user.getPassword().checkPassword(password)){
					return user;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	protected String getRequestOb() {
		return SELECT_USER_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SELECT_USERS;
	}

	@Override
	protected User getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(INDEX_ID_SELECT);
		String firstName = resultSet.getString(INDEX_FIRST_NAME_SELECT);
		String lastName = resultSet.getString(INDEX_LAST_NAME_SELECT);
		String emailAddress = resultSet.getString(INDEX_EMAIL_ADDRESS_SELECT);
		Role role = Role.valueOf(resultSet.getString(INDEX_ROLE_SELECT));
		Password password = new Password();
		password.setEncryptedPassword(resultSet.getString(INDEX_PASSWORD_SELECT));
		return new User(id, firstName, lastName, emailAddress, role, password);
	}

	@Override
	protected PreparedStatement getPreparedStatementAddOb(User ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_USER);
		setCommonValues(ps, ob);
		return ps;
	}
	
	@Override
	protected PreparedStatement getPreparedStatementChangeOb(User ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(UPDATE_USER);
		setCommonValues(ps, ob);
		ps.setInt(INDEX_ID_USER, ob.getId());
		return ps;
	}

	private static void setCommonValues(PreparedStatement ps, User ob) throws SQLException{
		ps.setString(INDEX_FIRST_NAME_INSERT, ob.getFirstName());
		ps.setString(INDEX_LAST_NAME_INSERT, ob.getLastName());
		ps.setString(INDEX_EMAIL_ADDRESS_INSERT, ob.getEmailAddress());
		ps.setString(INDEX_ROLE_INSERT, ob.getRole().toString());
		ps.setString(INDEX_PASSWORD_INSERT, ob.getPassword().getEncryptedPassword());
	}
}