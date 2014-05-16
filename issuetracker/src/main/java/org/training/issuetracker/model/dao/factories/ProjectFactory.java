/**
 * 
 */
package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.dao.IProjectDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.jdbc.SQLProjectDAOImpl;
import org.training.issuetracker.model.dao.xml.XmlProjectDAOImpl;
import org.training.issuetracker.model.properties.Config;

/**
 * @author Yury Kiryla
 *
 */
public class ProjectFactory {
	public static IProjectDAO getClassFromFactory() throws DAOException{
		switch (Config.getConfig().getImplementation()){
		case XML:
			return new XmlProjectDAOImpl();
		case JDBC:
			return new SQLProjectDAOImpl();
		default:
			throw new DAOException();
		}
	}
}
