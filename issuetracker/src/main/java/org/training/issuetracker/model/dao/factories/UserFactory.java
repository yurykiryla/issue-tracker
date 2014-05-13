/**
 * 
 */
package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.jdbc.SQLUserDAOImpl;

/**
 * @author Yury Kiryla
 *
 */
public class UserFactory {
	public static IUserDAO getClassFromFactory(){
		//return new XmlUserDAOImpl();
		return new SQLUserDAOImpl();
	}
}
