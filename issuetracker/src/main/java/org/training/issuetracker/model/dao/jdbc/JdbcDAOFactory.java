/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

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
 * @author Оля
 *
 */
public class JdbcDAOFactory implements AbstractFactory {

	/**
	 * 
	 */
	public JdbcDAOFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getIssueDAO()
	 */
	@Override
	public DAO<Issue> getIssueDAO() {
		// TODO Auto-generated method stub
		return new IssuesJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getPriorityDAO()
	 */
	@Override
	public DAO<Priority> getPriorityDAO() {
		// TODO Auto-generated method stub
		return new PriorityJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getProjectDAO()
	 */
	@Override
	public DAO<Project> getProjectDAO() {
		// TODO Auto-generated method stub
		return new ProjectJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getResolutionDAO()
	 */
	@Override
	public DAO<Resolution> getResolutionDAO() {
		// TODO Auto-generated method stub
		return new ResolutionJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getStatusDAO()
	 */
	@Override
	public DAO<Status> getStatusDAO() {
		// TODO Auto-generated method stub
		return new StatusJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getTypeDAO()
	 */
	@Override
	public DAO<Type> getTypeDAO() {
		// TODO Auto-generated method stub
		return new TypeJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getUserDAO()
	 */
	@Override
	public DAO<User> getUserDAO() {
		// TODO Auto-generated method stub
		return new UserJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getIssuesDAO()
	 */
	@Override
	public IssuesDAO getIssuesDAO() {
		// TODO Auto-generated method stub
		return new IssuesJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getUsersDAO()
	 */
	@Override
	public UsersDAO getUsersDAO() {
		// TODO Auto-generated method stub
		return new UserJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getBuildDAO()
	 */
	@Override
	public DAO<Build> getBuildDAO() {
		// TODO Auto-generated method stub
		return new BuildsJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.factories.AbstractFactory#getBuildsDAO()
	 */
	@Override
	public BuildsDAO getBuildsDAO() {
		// TODO Auto-generated method stub
		return new BuildsJdbcDAO();
	}

}
