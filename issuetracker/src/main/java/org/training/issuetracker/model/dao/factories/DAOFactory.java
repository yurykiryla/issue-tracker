/**
 * 
 */
package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury
 *
 */
public class DAOFactory {
	public static <T extends Beans> DAO<T> getClassFromFactory() throws DAOException{
		
		return null;
	}
}
