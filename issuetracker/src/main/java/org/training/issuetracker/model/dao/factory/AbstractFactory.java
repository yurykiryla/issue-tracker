package org.training.issuetracker.model.dao.factory;

import org.training.issuetracker.model.bean.Comment;
import org.training.issuetracker.model.bean.Priority;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.bean.Resolution;
import org.training.issuetracker.model.bean.Status;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.dao.BuildDAO;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssueDAO;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;

public interface AbstractFactory {
	public BuildDAO getBuildDAO() throws DAOException;
	public DAO<Comment> getCommentDAO();
	public IssueDAO getIssueDAO() throws DAOException;
	public DAO<Priority> getPriorityDAO() throws DAOException;
	public DAO<Project> getProjectDAO() throws DAOException;
	public DAO<Resolution> getResolutionDAO() throws DAOException;
	public DAO<Status> getStatusDAO() throws DAOException;
	public DAO<Type> getTypeDAO() throws DAOException;
	public UserDAO getUserDAO() throws DAOException;
}
