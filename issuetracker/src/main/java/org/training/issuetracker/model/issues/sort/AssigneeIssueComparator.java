package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.User;

public class AssigneeIssueComparator extends IssueComparator<User> {
	public AssigneeIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected User getT(Issue o) {
		return o.getAssignee();
	}
}