package org.training.issuetracker.model.dao.jdbc;


import org.training.issuetracker.model.bean.Comment;
import org.training.issuetracker.model.bean.Priority;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.bean.Resolution;
import org.training.issuetracker.model.bean.Status;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.BuildDAO;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssueDAO;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.AbstractFactory;

public class JdbcDAOFactory implements AbstractFactory {

	public JdbcDAOFactory() {
	}

	@Override
	public IssueDAO getIssueDAO() throws DAOException {
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
	public UserDAO getUserDAO() throws DAOException {
		return new UserJdbcDAO();
	}

	@Override
	public BuildDAO getBuildDAO() throws DAOException {
		return new BuildsJdbcDAO();
	}

	@Override
	public DAO<Comment> getCommentDAO() {
		return null;
	}

}