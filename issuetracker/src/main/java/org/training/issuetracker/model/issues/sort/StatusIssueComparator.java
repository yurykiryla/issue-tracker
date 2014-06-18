package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Status;

public class StatusIssueComparator extends IssueComparator<Status> {
	public StatusIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected Status getT(Issue o) {
		return o.getStatus();
	}
}