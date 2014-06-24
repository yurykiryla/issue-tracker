package org.training.issuetracker.model.dao.xml;

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



public class XmlDAOFactory implements AbstractFactory {
	public XmlDAOFactory() {
	}

	@Override
	public IssueDAO getIssueDAO() {
		return new IssuesXmlDAO();
	}

	@Override
	public DAO<Priority> getPriorityDAO() {
		return new PriorityXmlDAO();
	}

	@Override
	public DAO<Project> getProjectDAO() {
		return new ProjectXmlDAO();
	}

	@Override
	public DAO<Resolution> getResolutionDAO() {
		return new ResolutionXmlDAO();
	}

	@Override
	public DAO<Status> getStatusDAO() {
		return new StatusXmlDAO();
	}

	@Override
	public DAO<Type> getTypeDAO() {
		return new TypeXmlDAO();
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserXmlDAO();
	}

	@Override
	public BuildDAO getBuildDAO() {
		return new BuildXmlDAO();
	}

	@Override
	public DAO<Comment> getCommentDAO() {
		return null;
	}
}