/**
 * 
 */
package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public interface IIssueDAO {
	public List<Issue> getIssues(User user, int n) throws DAOException;
}
