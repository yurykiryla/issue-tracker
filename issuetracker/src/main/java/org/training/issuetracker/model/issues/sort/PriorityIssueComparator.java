/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;

/**
 * @author Yury
 *
 */
public class PriorityIssueComparator extends IssueComparator<Priority> {

	/**
	 * @param sortOrder
	 */
	public PriorityIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.issues.sort.IssueComparator#getT(org.training.issuetracker.model.beans.Issue)
	 */
	@Override
	protected Priority getT(Issue o) {
		// TODO Auto-generated method stub
		return o.getPriority();
	}

}
