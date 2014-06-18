package org.training.issuetracker.model.dao.xml;

import java.util.Comparator;

import org.training.issuetracker.model.beans.Issue;

public class IssuesCreateDateComparator implements Comparator<Issue> {

	public IssuesCreateDateComparator() {
	}

	@Override
	public int compare(Issue o1, Issue o2) {
		return o1.getCreateDate().compareTo(o2.getCreateDate());
	}
}