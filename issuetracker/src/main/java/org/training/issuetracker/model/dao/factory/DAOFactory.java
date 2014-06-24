package org.training.issuetracker.model.dao.factory;

import org.training.issuetracker.controller.Configuration;
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
import org.training.issuetracker.model.dao.hibernate.HibernateFactory;

public class DAOFactory {
	private static AbstractFactory factory = null;
	
	private static AbstractFactory getFactory() {
		if (factory == null) {
			switch (Configuration.get().getImplementation()) {
				case XML:
					//factory = new XmlDAOFactory();
					break;
				case JDBC:
					//factory = new JdbcDAOFactory();
					break;
				case HIBERNATE:
					factory = new HibernateFactory();
					break;
			}
		}
		return factory;
	}
	
	public static BuildDAO getBuildDAO() throws DAOException {
		return getFactory().getBuildDAO();
	}

	public static DAO<Comment> getCommentDAO() {
		return getFactory().getCommentDAO();
	}

	public static IssueDAO getIssueDAO() throws DAOException {
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

	public static UserDAO getUserDAO() throws DAOException {
		return getFactory().getUserDAO();
	}
}