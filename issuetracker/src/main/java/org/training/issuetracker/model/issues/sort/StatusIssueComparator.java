package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.Status;


public class StatusIssueComparator extends IssueComparator<Status> {
	public StatusIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected Status getT(Issue o) {
		return o.getStatus();
	}
}