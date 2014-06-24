package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.Priority;


public class PriorityIssueComparator extends IssueComparator<Priority> {
	public PriorityIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected Priority getT(Issue o) {
		return o.getPriority();
	}
}