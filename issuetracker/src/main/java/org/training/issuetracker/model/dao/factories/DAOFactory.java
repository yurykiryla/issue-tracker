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
import org.training.issuetracker.model.dao.hibernate.HibernateDAOFactory;
import org.training.issuetracker.model.dao.jdbc.JdbcDAOFactory;
import org.training.issuetracker.model.dao.xml.XmlDAOFactory;
import org.training.issuetracker.model.properties.Config;

public class DAOFactory {
	private static AbstractFactory factory = null;
	
	private static AbstractFactory getFactory() {
		if (factory == null) {
			switch (Config.getConfig().getImplementation()) {
				case XML:
					factory = new XmlDAOFactory();
					break;
				case JDBC:
					factory = new JdbcDAOFactory();
					break;
				case HIBERNATE:
					factory = new HibernateDAOFactory();
					break;
			}
		}
		return factory;
	}
	
	public static DAO<Issue> getIssueDAO() throws DAOException {
		return getFactory().getIssueDAO();
	}
	
	public static DAO<Priority> getPriorityDAO() throws DAOException {
		return getFactory().getPriorityDAO();
	}
	
	public static DAO<Project> getProjectDAO() throws DAOException {
		return getFactory().getProjectDAO();
	}
	
	public static DAO<Resolution> getResolutionDAO() throws DAOException {
		return getFactory().getResolutionDAO();
	}
	
	public static DAO<Status> getStatusDAO() throws DAOException {
		return getFactory().getStatusDAO();
	}
	
	public static DAO<Type> getTypeDAO() throws DAOException {
		return getFactory().getTypeDAO();
	}
	
	public static DAO<User> getUserDAO() throws DAOException {
		return getFactory().getUserDAO();
	}
	
	public static IssuesDAO getIssuesDAO() throws DAOException {
		return getFactory().getIssuesDAO();
	}
	
	public static UsersDAO getUsersDAO() throws DAOException {
		return getFactory().getUsersDAO();
	}
	
	public static DAO<Build> getBuildDAO() throws DAOException {
		return getFactory().getBuildDAO();
	}
	
	public static BuildsDAO getBuildsDAO() throws DAOException {
		return getFactory().getBuildsDAO();
	}
}