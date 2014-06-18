package org.training.issuetracker.model.dao.xml;

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
import org.training.issuetracker.model.dao.factories.AbstractFactory;

public class XmlDAOFactory implements AbstractFactory {
	public XmlDAOFactory() {
	}

	@Override
	public DAO<Issue> getIssueDAO() {
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
	public DAO<User> getUserDAO() {
		return new UserXmlDAO();
	}

	@Override
	public IssuesDAO getIssuesDAO() {
		return new IssuesXmlDAO();
	}

	@Override
	public UsersDAO getUsersDAO() {
		return new UserXmlDAO();
	}

	@Override
	public DAO<Build> getBuildDAO() {
		return new BuildXmlDAO();
	}

	@Override
	public BuildsDAO getBuildsDAO() {
		return new BuildXmlDAO();
	}
}