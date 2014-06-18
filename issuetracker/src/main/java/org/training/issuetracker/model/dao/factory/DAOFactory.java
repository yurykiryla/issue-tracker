package org.training.issuetracker.model.dao.factory;

import org.training.issuetracker.controller.Configuration;
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
	
	public static DAO<Build> getBuildDAO() {
		return getFactory().getBuildDAO();
	}

	public static DAO<Comment> getCommentDAO() {
		return getFactory().getCommentDAO();
	}

	public static IssueDAO getIssueDAO() {
		return getFactory().getIssueDAO();
	}

	public static DAO<Priority> getPriorityDAO() {
		return getFactory().getPriorityDAO();
	}

	public static DAO<Project> getProjectDAO() {
		return getFactory().getProjectDAO();
	}

	public static DAO<Resolution> getResolutionDAO() {
		return getFactory().getResolutionDAO();
	}

	public static DAO<Status> getStatusDAO() {
		return getFactory().getStatusDAO();
	}

	public static DAO<Type> getTypeDAO() {
		return getFactory().getTypeDAO();
	}

	public static UserDAO getUserDAO() {
		return getFactory().getUserDAO();
	}
}