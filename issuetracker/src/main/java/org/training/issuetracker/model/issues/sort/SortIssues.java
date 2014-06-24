package org.training.issuetracker.model.issues.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.training.issuetracker.model.bean.Issue;

public class SortIssues {
	private static List<Issue> issues = null;
	private static SortKeys sortKey;
	private static SortOrders sortOrder;
	
	public static void sort(List<Issue> issues) {
		SortIssues.issues = issues;
		sortKey = SortKeys.ID;
		sortOrder = SortOrders.ASC;
		Collections.sort(issues);
	}
	
	public static List<Issue> getSortedList(String key) {
		if (issues == null) {
			throw new IllegalArgumentException();
		}
		SortKeys sortKey = SortKeys.valueOf(key.toUpperCase());
		if (sortKey == SortIssues.sortKey) {
			if (sortOrder == SortOrders.ASC) {
				sortOrder = SortOrders.DESC;
			} else {
				sortOrder = SortOrders.ASC;
			}
		} else {
			sortOrder = SortOrders.ASC;
		}
		SortIssues.sortKey = sortKey;
		Comparator<Issue> comparator = ComparatorFactory.getIssuesComparator(sortKey, sortOrder);
		Collections.sort(issues, comparator);
		return issues;
	}
}