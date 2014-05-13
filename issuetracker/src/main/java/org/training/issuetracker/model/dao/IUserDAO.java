/**
 * 
 */
package org.training.issuetracker.model.dao;

import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public interface IUserDAO{
	public User getUser(String email, String password) throws DAOException;
	public User getUser(int id) throws DAOException;
}
