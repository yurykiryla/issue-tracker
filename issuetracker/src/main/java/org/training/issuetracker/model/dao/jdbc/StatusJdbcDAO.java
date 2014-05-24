package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class StatusJdbcDAO extends JdbcDAO<Status>{

	public StatusJdbcDAO() {
	}

	@Override
	protected String getRequestOb() {
		return SQLRequests.SELECT_STATUS_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SQLRequests.SELECT_STATUSES;
	}

	@Override
	protected Status getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(Constants.INDEX_ID_SELECT);
		String name = resultSet.getString(Constants.INDEX_NAME_SELECT);
		return new Status(id, name);
	}

	@Override
	protected PreparedStatement getPreparedStatement(Status ob)
			throws DAOException {
		return null;
	}

	@Override
	public void addOb(Status ob) throws DAOException {
		throw new DAOException();
	}
}