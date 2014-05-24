/**
 * 
 */
package org.training.issuetracker.model.issues.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.training.issuetracker.model.beans.Issue;

/**
 * @author Yury
 *
 */
public class SortIssues {
	private static List<Issue> issues = null;
	private static SortKeys sortKey;
	private static SortOrders sortOrder;
	
	public static void sort(List<Issue> issues){
		SortIssues.issues = issues;
		sortKey = SortKeys.ID;
		sortOrder = SortOrders.ASK;
		Collections.sort(issues);
	}
	
	public static void sort(String key){
		if(issues == null){
			throw new RuntimeException();
		}
		SortKeys sortKey = SortKeys.valueOf(key.toUpperCase());
		if(sortKey == SortIssues.sortKey){
			if(sortOrder == SortOrders.ASK){
				sortOrder = SortOrders.DESK;
			}else{
				sortOrder = SortOrders.ASK;
			}
		}
		Comparator<Issue> comparator = ComparatorFactory.getIssuesComparator(sortKey, sortOrder);
		Collections.sort(issues, comparator);
	}
}
