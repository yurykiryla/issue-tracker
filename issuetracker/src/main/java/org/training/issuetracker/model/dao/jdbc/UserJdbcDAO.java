package org.training.issuetracker.model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class UserJdbcDAO extends JdbcDAO<User> implements UserDAO {

	public UserJdbcDAO() throws DAOException {
		super();
	}

	@Override
	public User getUser(String email, String password) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SELECT_USER_BY_EMAIL);
			ps.setString(INDEX_EMAIL_ADDRESS_FIND, email);
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				User user = getOb(rs);
				if(user.getPassword() == password){
					return user;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(rs, ps, con);
		}
		return null;
	}

	@Override
	protected String getRequestGetObById() throws DAOException {
		return SELECT_USER_BY_ID;
	}

	@Override
	protected String getRequestGetObs() throws DAOException {
		return SELECT_USERS;
	}

	@Override
	protected User getOb(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt(INDEX_ID_SELECT);
		String firstName = rs.getString(INDEX_FIRST_NAME_SELECT);
		String lastName = rs.getString(INDEX_LAST_NAME_SELECT);
		String emailAddress = rs.getString(INDEX_EMAIL_ADDRESS_SELECT);
		Role role = Role.valueOf(rs.getString(INDEX_ROLE_SELECT));
		return new User();
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		return INSERT_USER;
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, User ob)
			throws DAOException, SQLException {
		ps.setString(INDEX_FIRST_NAME_INSERT, ob.getFirstName());
		ps.setString(INDEX_LAST_NAME_INSERT, ob.getLastName());
		ps.setString(INDEX_EMAIL_ADDRESS_INSERT, ob.getEmail());
		ps.setString(INDEX_ROLE_INSERT, ob.getRole().toString());
		ps.setString(INDEX_PASSWORD_INSERT, ob.getPassword());
		return ps;
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		return UPDATE_USER;
	}

	@Override
	protected int getChangedObId() throws DAOException {
		return INDEX_ID_USER;
	}
}