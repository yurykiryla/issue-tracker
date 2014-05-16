package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.dao.IIssueDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.jdbc.SQLIssueDAOImpl;
import org.training.issuetracker.model.dao.xml.XmlIssueDAOImpl;
import org.training.issuetracker.model.properties.Config;

public class IssuesFactory {
	public static IIssueDAO getClassFromFactory() throws DAOException{
		switch (Config.getConfig().getImplementation()){
			case XML:
				return new XmlIssueDAOImpl();
			case JDBC:
				return new SQLIssueDAOImpl();
			default:
				throw new DAOException();
		}
	}
}
