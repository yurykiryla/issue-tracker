/**
 * 
 */
package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.dao.IBuildDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.xml.XmlBuildDAOImpl;
import org.training.issuetracker.model.properties.Config;

/**
 * @author Yury Kiryla
 *
 */
public class BuildFactory {
	public static IBuildDAO getClassFromFactory() throws DAOException{
		switch (Config.getConfig().getImplementation()){
		case XML:
			return new XmlBuildDAOImpl();
		/*case JDBC:
			return new SQLBuildDAOImpl();*/
		default:
			throw new DAOException();
		}
	}
}
