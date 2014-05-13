/**
 * 
 */
package org.training.issuetracker.model.dao;

import org.training.issuetracker.model.beans.User;

/**
 * @author Yury Kiryla
 *
 */
public interface IUserDAO {
	public User getUser(String email, String password);
	public User getUser(int id);
}
