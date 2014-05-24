package org.training.issuetracker.model.issues.sort;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Type;

public class TypeIssueComparator extends IssueComparator<Type> {
	public TypeIssueComparator(SortOrders sortOrder) {
		super(sortOrder);
	}

	@Override
	protected Type getT(Issue o) {
		return o.getType();
	}
}