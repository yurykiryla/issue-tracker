package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;

public class IdIssueComparator extends IssueComparator<Issue>{
	public IdIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected Issue getT(Issue o) {
		return o;
	}
}