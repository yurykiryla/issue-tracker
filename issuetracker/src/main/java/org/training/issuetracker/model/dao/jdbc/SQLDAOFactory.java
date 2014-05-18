/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.factories.AbstractFactory;

/**
 * @author Yury
 *
 */
public class SQLDAOFactory implements AbstractFactory {

	/**
	 * 
	 */
	public SQLDAOFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getIssueDAO()
	 */
	@Override
	public DAO<Issue> getIssueDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getPriorityDAO()
	 */
	@Override
	public DAO<Priority> getPriorityDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getProjectDAO()
	 */
	@Override
	public DAO<Project> getProjectDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getResolutionDAO()
	 */
	@Override
	public DAO<Resolution> getResolutionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getStatusDAO()
	 */
	@Override
	public DAO<Status> getStatusDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getTypeDAO()
	 */
	@Override
	public DAO<Type> getTypeDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getUserDAO()
	 */
	@Override
	public DAO<User> getUserDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
