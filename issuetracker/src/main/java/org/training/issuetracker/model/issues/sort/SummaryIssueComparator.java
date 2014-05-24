package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;

public class SummaryIssueComparator extends IssueComparator<String> {
	public SummaryIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected String getT(Issue o) {
		return o.getSummary();
	}
}