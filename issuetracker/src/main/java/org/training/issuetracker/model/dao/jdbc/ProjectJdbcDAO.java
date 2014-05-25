package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class ProjectJdbcDAO extends JdbcDAO<Project> {

	public ProjectJdbcDAO() {
	}

	@Override
	protected String getRequestOb() {
		return SELECT_PROJECT_BY_ID;
	}

	@Override
	protected String getRequestObs() {
		return SELECT_PROJECTS;
	}

	@Override
	protected Project getOb(ResultSet resultSet) throws DAOException, SQLException {
		int id = resultSet.getInt(INDEX_ID_SELECT);
		String name = resultSet.getString(INDEX_NAME_SELECT);
		String description = resultSet.getString(INDEX_PROJECT_DESCRIPTION_SELECT);
		List<Build> builds = DAOFactory.getBuildsDAO().getBuilds(id);
		User manager = DAOFactory.getUserDAO().getOb(resultSet.getInt(INDEX_MANAGER_ID_SELECT));
		return new Project(id, name, description, builds, manager);
	}

	@Override
	protected PreparedStatement getPreparedStatementAddOb(Project ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_PROJECT);
		setCommonValues(ps, ob);
		return ps;
	}
	
	@Override
	protected PreparedStatement getPreparedStatementChangeOb(Project ob)
			throws DAOException, SQLException {
		PreparedStatement ps = getPreparedStatement(SQLRequests.UPDATE_PROJECT);
		setCommonValues(ps, ob);
		ps.setInt(INDEX_ID_PROJECT, ob.getId());
		return ps;
	}

	private static void setCommonValues(PreparedStatement ps, Project ob) throws SQLException {
		ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
		ps.setString(INDEX_PROJECT_DESCRIPTION_INSERT, ob.getDescription());
		ps.setInt(INDEX_MANAGER_ID_INSERT, ob.getManager().getId());
	}
}