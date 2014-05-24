/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.User;

/**
 * @author Yury
 *
 */
public class AssigneeIssueComparator extends IssueComparator<User> {

	/**
	 * @param sortOrder
	 */
	public AssigneeIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.issues.sort.IssueComparator#getT(org.training.issuetracker.model.beans.Issue)
	 */
	@Override
	protected User getT(Issue o) {
		// TODO Auto-generated method stub
		return o.getAssignee();
	}

}
