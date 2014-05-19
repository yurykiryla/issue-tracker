/**
 * 
 */
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

/**
 * @author Yury
 *
 */
public class XmlDAOFactory implements AbstractFactory {

	/**
	 * 
	 */
	public XmlDAOFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getIssueDAO()
	 */
	@Override
	public DAO<Issue> getIssueDAO() {
		// TODO Auto-generated method stub
		return new IssuesXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getPriorityDAO()
	 */
	@Override
	public DAO<Priority> getPriorityDAO() {
		// TODO Auto-generated method stub
		return new PriorityXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getProjectDAO()
	 */
	@Override
	public DAO<Project> getProjectDAO() {
		// TODO Auto-generated method stub
		return new ProjectXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getResolutionDAO()
	 */
	@Override
	public DAO<Resolution> getResolutionDAO() {
		// TODO Auto-generated method stub
		return new ResolutionXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getStatusDAO()
	 */
	@Override
	public DAO<Status> getStatusDAO() {
		// TODO Auto-generated method stub
		return new StatusXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getTypeDAO()
	 */
	@Override
	public DAO<Type> getTypeDAO() {
		// TODO Auto-generated method stub
		return new TypeXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getUserDAO()
	 */
	@Override
	public DAO<User> getUserDAO() {
		// TODO Auto-generated method stub
		return new UserXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getIssuesDAO()
	 */
	@Override
	public IssuesDAO getIssuesDAO() {
		// TODO Auto-generated method stub
		return new IssuesXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getUsersDAO()
	 */
	@Override
	public UsersDAO getUsersDAO() {
		// TODO Auto-generated method stub
		return new UserXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getBuildDAO()
	 */
	@Override
	public DAO<Build> getBuildDAO() {
		// TODO Auto-generated method stub
		return new BuildXmlDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getBuildsDAO()
	 */
	@Override
	public BuildsDAO getBuildsDAO() {
		// TODO Auto-generated method stub
		return new BuildXmlDAO();
	}

}
