/**
 * 
 */
package org.training.issuetracker.model.beans;

import org.training.issuetracker.model.issues.sort.IssueComparator;
import org.training.issuetracker.model.issues.sort.SortOrders;

/**
 * @author Yury
 *
 */
public class SummaryIssueComparator extends IssueComparator<String> {

	/**
	 * @param sortOrder
	 */
	public SummaryIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.issues.sort.IssueComparator#getT(org.training.issuetracker.model.beans.Issue)
	 */
	@Override
	protected String getT(Issue o) {
		// TODO Auto-generated method stub
		return o.getSummary();
	}

}
