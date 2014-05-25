package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.BuildsDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class BuildsJdbcDAO extends JdbcDAO<Build> implements BuildsDAO{
	private int projectId = 0;

	public BuildsJdbcDAO() {
	}

	@Override
	public List<Build> getBuilds(int projectId) throws DAOException {
		List<Build> builds = new ArrayList<>();
		try {
			resultSet = getResultSet(SELECT_BUILDS_BY_PROJECT_ID + projectId);
			while (resultSet != null && resultSet.next()) {
				builds.add(getOb(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection();
		}
		return builds;
	}

	@Override
	protected String getRequestOb() {
		return SELECT_BUILD_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SELECT_BUILDS;
	}

	@Override
	protected Build getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(INDEX_ID_SELECT);
		String name = resultSet.getString(INDEX_NAME_SELECT);
		return new Build(id, name);
	}

	@Override
	public void addOb(Build ob) throws DAOException {
		throw new DAOException(MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected PreparedStatement getPreparedStatementAddOb(Build ob)
			throws DAOException, SQLException {
		if (projectId != 0) {
			PreparedStatement ps = getPreparedStatement(INSERT_BUILD);
			ps.setString(INDEX_NAME_INSERT, ob.getName());
			ps.setInt(INDEX_BUILD_PROJECT_ID_INSERT, projectId);
			return ps;
		}
		return null;
	}

	@Override
	public void addBuild(Build build, int projectId) throws DAOException {
		this.projectId = projectId;
		super.addOb(build);
	}

	@Override
	protected PreparedStatement getPreparedStatementChangeOb(Build ob)
			throws DAOException, SQLException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}
}