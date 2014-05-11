/**
 * 
 */
package model.factories;

import model.implementations.SQLUserDAOImpl;
import model.implementations.XmlUserDAOImpl;
import model.interfaces.IUserDAO;

/**
 * @author Yury Kiryla
 *
 */
public class UserFactory {
	public static IUserDAO getClassFromFactory(){
		return new SQLUserDAOImpl();
	}
}
