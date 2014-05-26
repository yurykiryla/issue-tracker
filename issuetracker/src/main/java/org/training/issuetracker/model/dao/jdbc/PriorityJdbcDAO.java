package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class PriorityJdbcDAO extends JdbcDAO<Priority>{

	@Override
	protected String getRequestGetObById() throws DAOException {
		return SQLRequests.SELECT_PRIORITY_BY_ID;
	}

	@Override
	protected String getRequestGetObs() throws DAOException {
		return SQLRequests.SELECT_PRIORITIES;
	}

	@Override
	protected Priority getOb(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt(Constants.INDEX_ID_SELECT);
		String name = rs.getString(Constants.INDEX_NAME_SELECT);
		return new Priority(id, name);
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		return SQLRequests.INSERT_PRIORITY;
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, Priority ob)
			throws DAOException, SQLException {
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		return ps;
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		return SQLRequests.UPDATE_PRIORITY;
	}

	@Override
	protected int getChangedObId() {
		return Constants.INDEX_ID_PRIORITY;
	}
}