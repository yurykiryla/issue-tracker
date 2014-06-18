package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;

public interface IssueDAO extends DAO<Issue> {
	public List<Issue> getIssues(User user, int n) throws DAOException;
	public List<Issue> getSortedIssues(User user, int n, String key) throws DAOException;
}
