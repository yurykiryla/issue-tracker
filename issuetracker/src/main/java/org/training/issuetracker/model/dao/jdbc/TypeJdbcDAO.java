package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class TypeJdbcDAO extends JdbcDAO<Type> {

	public TypeJdbcDAO() throws DAOException {
		super();
	}

	@Override
	protected String getRequestGetObById() throws DAOException {
		return SQLRequests.SELECT_TYPE_BY_ID;
	}

	@Override
	protected String getRequestGetObs() throws DAOException {
		return SQLRequests.SELECT_TYPES;
	}

	@Override
	protected Type getOb(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt(Constants.INDEX_ID_SELECT);
		String name = rs.getString(Constants.INDEX_NAME_SELECT);
		return new Type();
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		return SQLRequests.INSERT_TYPE;
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, Type ob)
			throws DAOException, SQLException {
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		return ps;
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		return SQLRequests.UPDATE_TYPE;
	}

	@Override
	protected int getChangedObId() throws DAOException {
		return Constants.INDEX_ID_TYPE;
	}
}