package org.training.issuetracker.model.dao.hibernate;

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
import org.training.issuetracker.model.dao.factory.AbstractFactory;

public class HibernateFactory implements AbstractFactory {

	@Override
	public BuildDAO getBuildDAO() {
		return new BuildHibernateDAO();
	}

	@Override
	public DAO<Comment> getCommentDAO() {
		return new CommentHibernateDAO();
	}

	@Override
	public IssueDAO getIssueDAO() {
		return new IssueHibernateDAO();
	}

	@Override
	public DAO<Priority> getPriorityDAO() {
		return new PriorityHibernateDAO();
	}

	@Override
	public DAO<Project> getProjectDAO() {
		return new ProjectHibernateDAO();
	}

	@Override
	public DAO<Resolution> getResolutionDAO() {
		return new ResolutionHibernateDAO();
	}

	@Override
	public DAO<Status> getStatusDAO() {
		return new StatusHibernateDAO();
	}

	@Override
	public DAO<Type> getTypeDAO() {
		return new TypeHibernateDAO();
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserHibernateDAO();
	}
}
