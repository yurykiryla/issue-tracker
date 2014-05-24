/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import java.util.Comparator;

import org.training.issuetracker.model.beans.Issue;

/**
 * @author Yury
 *
 */
public abstract class IssueComparator<T extends Comparable<T>> implements Comparator<Issue> {
	private SortOrders sortOrder;
	
	/**
	 * @param sortOrder
	 */
	public IssueComparator(SortOrders sortOrder) {
		super();
		this.sortOrder = sortOrder;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Issue o1, Issue o2) {
		// TODO Auto-generated method stub
		if(sortOrder == SortOrders.ASK){
			return getT(o1).compareTo(getT(o2));
		}
		return getT(o2).compareTo(getT(o1));
	}
	
	protected abstract T getT(Issue o);
}
