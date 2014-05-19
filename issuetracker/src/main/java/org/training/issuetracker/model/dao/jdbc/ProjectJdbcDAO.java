/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

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

/**
 * @author Yury Kiryla
 *
 */
public class ProjectJdbcDAO extends JdbcDAO<Project> {

	/**
	 * 
	 */
	public ProjectJdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SELECT_PROJECT_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SELECT_PROJECTS;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected Project getOb(ResultSet resultSet) throws DAOException {
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(INDEX_ID);
			String name = resultSet.getString(INDEX_NAME);
			String description = resultSet.getString(INDEX_PROJECT_DESCRIPTION);
			List<Build> builds = DAOFactory.getBuildsDAO().getBuilds(id);
			User manager = DAOFactory.getUserDAO().getOb(resultSet.getInt(INDEX_MANAGER_ID));
			return new Project(id, name, description, builds, manager);
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}

}
