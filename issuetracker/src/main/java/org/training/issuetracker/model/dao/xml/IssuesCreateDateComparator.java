package org.training.issuetracker.model.dao.xml;

import java.util.Comparator;

import org.training.issuetracker.model.beans.Issue;

public class IssuesCreateDateComparator implements Comparator<Issue> {

	public IssuesCreateDateComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Issue o1, Issue o2) {
		// TODO Auto-generated method stub
		return (int)(o2.getCreateDate().getTime() - o1.getCreateDate().getTime());
	}

}
