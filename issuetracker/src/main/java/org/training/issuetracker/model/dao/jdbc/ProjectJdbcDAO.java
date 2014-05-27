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

	public ProjectJdbcDAO() throws DAOException {
		super();
	}

	@Override
	protected String getRequestGetObById() throws DAOException {
		return SELECT_PROJECT_BY_ID;
	}

	@Override
	protected String getRequestGetObs() throws DAOException {
		return SELECT_PROJECTS;
	}

	@Override
	protected Project getOb(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt(INDEX_ID_SELECT);
		String name = rs.getString(INDEX_NAME_SELECT);
		String description = rs.getString(INDEX_PROJECT_DESCRIPTION_SELECT);
		List<Build> builds = DAOFactory.getBuildsDAO().getBuilds(id);
		User manager = DAOFactory.getUserDAO().getOb(rs.getInt(INDEX_MANAGER_ID_SELECT));
		return new Project(id, name, description, builds, manager);
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		return INSERT_PROJECT;
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, Project ob)
			throws DAOException, SQLException {
		ps.setString(INDEX_NAME_INSERT, ob.getName());
		ps.setString(INDEX_PROJECT_DESCRIPTION_INSERT, ob.getDescription());
		ps.setInt(INDEX_MANAGER_ID_INSERT, ob.getManager().getId());
		return ps;
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		return UPDATE_PROJECT;
	}

	@Override
	protected int getChangedObId() {
		return INDEX_ID_PROJECT;
	}
}