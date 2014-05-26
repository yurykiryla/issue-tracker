package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class StatusJdbcDAO extends JdbcDAO<Status>{

	@Override
	protected String getRequestGetObById() throws DAOException {
		return SQLRequests.SELECT_STATUS_BY_ID;
	}

	@Override
	protected String getRequestGetObs() throws DAOException {
		return SQLRequests.SELECT_STATUSES;
	}

	@Override
	protected Status getOb(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt(Constants.INDEX_ID_SELECT);
		String name = rs.getString(Constants.INDEX_NAME_SELECT);
		return new Status(id, name);
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, Status ob)
			throws DAOException, SQLException {
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		return ps;
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		return SQLRequests.UPDATE_STATUS;
	}

	@Override
	protected int getChangedObId() {
		return Constants.INDEX_ID_STATUS;
	}
}