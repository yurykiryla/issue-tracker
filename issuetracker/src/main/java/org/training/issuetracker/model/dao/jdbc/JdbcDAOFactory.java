package org.training.issuetracker.model.dao.jdbc;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.BuildsDAO;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssuesDAO;
import org.training.issuetracker.model.dao.UsersDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.AbstractFactory;

public class JdbcDAOFactory implements AbstractFactory {

	public JdbcDAOFactory() {
	}

	@Override
	public DAO<Issue> getIssueDAO() throws DAOException {
		return new IssuesJdbcDAO();
	}

	@Override
	public DAO<Priority> getPriorityDAO() throws DAOException {
		return new PriorityJdbcDAO();
	}

	@Override
	public DAO<Project> getProjectDAO() throws DAOException {
		return new ProjectJdbcDAO();
	}

	@Override
	public DAO<Resolution> getResolutionDAO() throws DAOException {
		return new ResolutionJdbcDAO();
	}

	@Override
	public DAO<Status> getStatusDAO() throws DAOException {
		return new StatusJdbcDAO();
	}

	@Override
	public DAO<Type> getTypeDAO() throws DAOException {
		return new TypeJdbcDAO();
	}

	@Override
	public DAO<User> getUserDAO() throws DAOException {
		return new UserJdbcDAO();
	}

	@Override
	public IssuesDAO getIssuesDAO() throws DAOException {
		return new IssuesJdbcDAO();
	}

	@Override
	public UsersDAO getUsersDAO() throws DAOException {
		return new UserJdbcDAO();
	}

	@Override
	public DAO<Build> getBuildDAO() throws DAOException {
		return new BuildsJdbcDAO();
	}

	@Override
	public BuildsDAO getBuildsDAO() throws DAOException {
		return new BuildsJdbcDAO();
	}
}