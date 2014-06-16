package org.training.issuetracker.model.dao.hibernate;

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

public class HibernateDAOFactory implements AbstractFactory {

	public HibernateDAOFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DAO<Issue> getIssueDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Priority> getPriorityDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Project> getProjectDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Resolution> getResolutionDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Status> getStatusDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Type> getTypeDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<User> getUserDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuesDAO getIssuesDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersDAO getUsersDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Build> getBuildDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuildsDAO getBuildsDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
