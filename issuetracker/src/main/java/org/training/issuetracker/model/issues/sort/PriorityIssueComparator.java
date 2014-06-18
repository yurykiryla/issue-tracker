package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;

public class PriorityIssueComparator extends IssueComparator<Priority> {
	public PriorityIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected Priority getT(Issue o) {
		return o.getPriority();
	}
}