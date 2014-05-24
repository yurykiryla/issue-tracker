package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class TypeJdbcDAO extends JdbcDAO<Type> {

	public TypeJdbcDAO() {
	}

	@Override
	protected String getRequestOb() {
		return SQLRequests.SELECT_TYPE_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SQLRequests.SELECT_TYPES;
	}

	@Override
	protected Type getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(Constants.INDEX_ID_SELECT);
		String name = resultSet.getString(Constants.INDEX_NAME_SELECT);
		return new Type(id, name);
	}

	@Override
	protected PreparedStatement getPreparedStatement(Type ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_TYPE);
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		return ps;
	}
}