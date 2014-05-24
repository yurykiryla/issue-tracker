/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Status;

/**
 * @author Yury
 *
 */
public class StatusIssueComparator extends IssueComparator<Status> {

	/**
	 * @param sortOrder
	 */
	public StatusIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.issues.sort.IssueComparator#getT(org.training.issuetracker.model.beans.Issue)
	 */
	@Override
	protected Status getT(Issue o) {
		// TODO Auto-generated method stub
		return o.getStatus();
	}

}
