package org.training.issuetracker.model.dao.factories;

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

public interface AbstractFactory {
	public DAO<Issue> getIssueDAO() throws DAOException;
	public DAO<Priority> getPriorityDAO() throws DAOException;
	public DAO<Project> getProjectDAO() throws DAOException;
	public DAO<Resolution> getResolutionDAO() throws DAOException;
	public DAO<Status> getStatusDAO() throws DAOException;
	public DAO<Type> getTypeDAO() throws DAOException;
	public DAO<User> getUserDAO() throws DAOException;
	public IssuesDAO getIssuesDAO() throws DAOException;
	public UsersDAO getUsersDAO() throws DAOException;
	public DAO<Build> getBuildDAO() throws DAOException;
	public BuildsDAO getBuildsDAO() throws DAOException;
}