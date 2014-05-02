package model.implementations;

import java.util.Comparator;

import model.beans.Issue;

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
