/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Type;

/**
 * @author Yury
 *
 */
public class TypeIssueComparator extends IssueComparator<Type> {

	/**
	 * @param sortOrder
	 */
	public TypeIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.issues.sort.IssueComparator#getT(org.training.issuetracker.model.beans.Issue)
	 */
	@Override
	protected Type getT(Issue o) {
		// TODO Auto-generated method stub
		return o.getType();
	}

}
