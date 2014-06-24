package org.training.issuetracker.model.issues.sort;

import java.util.Comparator;

import org.training.issuetracker.model.bean.Issue;

public abstract class IssueComparator<T extends Comparable<T>> implements Comparator<Issue> {
	private SortOrders sortOrder;
	
	public IssueComparator(SortOrders sortOrder) {
		super();
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(Issue o1, Issue o2) {
		T t1 = getT(o1);
		T t2 = getT(o2);
		if (t1 == null) {
			if (t2 == null) {
				return 0;
			} else {
				return 1;
			}
		}
		if (t2 == null) {
			return -1;
		}
		if (sortOrder == SortOrders.ASC) {
			return t1.compareTo(t2);
		}
		return t2.compareTo(t1);
	}
	
	protected abstract T getT(Issue o);
}