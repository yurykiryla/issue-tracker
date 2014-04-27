/**
 * 
 */
package model.interfaces;

import model.beans.Issue;

/**
 * @author Yury Kiryla
 *
 */
public interface IIssueDAO {
	public boolean hasNextIssue();
	public Issue getNextIssue();
}
