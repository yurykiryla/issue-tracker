package org.training.issuetracker.model.issues.sort;

import java.util.Comparator;

import org.training.issuetracker.model.bean.Issue;

public class ComparatorFactory {
	public static Comparator<Issue> getIssuesComparator(SortKeys sortKey, SortOrders sortOrder){
		switch(sortKey){
			case ID:
				return new IdIssueComparator(sortOrder);
			case ASSIGNEE:
				return new AssigneeIssueComparator(sortOrder);
			case PRIORITY:
				return new PriorityIssueComparator(sortOrder);
			case STATUS:
				return new StatusIssueComparator(sortOrder);
			case SUMMARY:
				return new SummaryIssueComparator(sortOrder);
			case TYPE:
				return new TypeIssueComparator(sortOrder);
			default:
				return null;
		}
	}
}