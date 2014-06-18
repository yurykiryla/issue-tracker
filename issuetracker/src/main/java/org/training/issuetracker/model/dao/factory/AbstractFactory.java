package org.training.issuetracker.model.dao.factory;

import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Comment;
import org.training.issuetracker.model.bean.Priority;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.bean.Resolution;
import org.training.issuetracker.model.bean.Status;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssueDAO;
import org.training.issuetracker.model.dao.UserDAO;

public interface AbstractFactory {
	public DAO<Build> getBuildDAO();
	public DAO<Comment> getCommentDAO();
	public IssueDAO getIssueDAO();
	public DAO<Priority> getPriorityDAO();
	public DAO<Project> getProjectDAO();
	public DAO<Resolution> getResolutionDAO();
	public DAO<Status> getStatusDAO();
	public DAO<Type> getTypeDAO();
	public UserDAO getUserDAO();
}
