/**
 * 
 */
package model.interfaces;

import java.util.List;

import model.beans.Issue;
import model.beans.User;

/**
 * @author Yury Kiryla
 *
 */
public interface IIssueDAO {
	public List<Issue> getIssues(User user, int n);
}
