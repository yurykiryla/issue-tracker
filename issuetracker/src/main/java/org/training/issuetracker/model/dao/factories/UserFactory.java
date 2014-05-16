/**
 * 
 */
package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.jdbc.SQLUserDAOImpl;
import org.training.issuetracker.model.dao.xml.XmlUserDAOImpl;
import org.training.issuetracker.model.properties.Config;

/**
 * @author Yury Kiryla
 *
 */
public class UserFactory {
	
	public static IUserDAO getClassFromFactory() throws DAOException{
		switch (Config.getConfig().getImplementation()){
			case XML:
				return new XmlUserDAOImpl();
			case JDBC:
				return new SQLUserDAOImpl();
			default:
				throw new DAOException();
		}
	}
}
