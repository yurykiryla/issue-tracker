/**
 * 
 */
package model.interfaces;

import model.beans.User;

/**
 * @author Yury Kiryla
 *
 */
public interface IUserDAO {
	public User getUser(String email, String password);
}
