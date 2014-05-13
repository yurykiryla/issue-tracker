package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.dao.IIssueDAO;
import org.training.issuetracker.model.dao.jdbc.SQLIssueDAOImpl;

public class IssuesFactory {
	public static IIssueDAO getClassFromFactory(){
		return new SQLIssueDAOImpl();
	}
}
