package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.User;

public class AssigneeIssueComparator extends IssueComparator<User> {
	public AssigneeIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected User getT(Issue o) {
		return o.getAssignee();
	}
}