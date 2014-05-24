/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;

/**
 * @author Yury
 *
 */
public class IdIssueComparator extends IssueComparator<Issue>{

	/**
	 * @param sortOrder
	 */
	public IdIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.issues.sort.IssueComparator#getT(org.training.issuetracker.model.beans.Issue)
	 */
	@Override
	protected Issue getT(Issue o) {
		// TODO Auto-generated method stub
		return o;
	}
	
}
