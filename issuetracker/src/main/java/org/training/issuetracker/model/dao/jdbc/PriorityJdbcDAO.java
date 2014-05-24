package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class PriorityJdbcDAO extends JdbcDAO<Priority>{

	public PriorityJdbcDAO() {
	}

	@Override
	protected String getRequestOb() {
		return SQLRequests.SELECT_PRIORITY_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SQLRequests.SELECT_PRIORITIES;
	}

	@Override
	protected Priority getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(Constants.INDEX_ID_SELECT);
		String name = resultSet.getString(Constants.INDEX_NAME_SELECT);
		return new Priority(id, name);
	}

	@Override
	protected PreparedStatement getPreparedStatement(Priority ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_PRIORITY);
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		return ps;
	}
}