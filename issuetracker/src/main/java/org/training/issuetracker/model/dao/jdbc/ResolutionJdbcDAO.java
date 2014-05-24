package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class ResolutionJdbcDAO extends JdbcDAO<Resolution> {

	public ResolutionJdbcDAO() {
	}

	@Override
	protected String getRequestOb() {
		return SQLRequests.SELECT_RESOLUTION_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SQLRequests.SELECT_RESOLUTIONS;
	}

	@Override
	protected Resolution getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(Constants.INDEX_ID_SELECT);
		String name = resultSet.getString(Constants.INDEX_NAME_SELECT);
		return new Resolution(id, name);
	}

	@Override
	protected PreparedStatement getPreparedStatement(Resolution ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_RESOLUTION);
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		return ps;
	}
}