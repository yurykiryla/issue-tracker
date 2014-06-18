package org.training.issuetracker.model.dao.hibernate;


import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.training.issuetracker.model.bean.Issue;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.IssueDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.enums.SortKey;
import org.training.issuetracker.model.enums.SortOrder;

public class IssueHibernateDAO extends HibernateDAO<Issue> implements IssueDAO {
	private static SortOrder sortOrder;
	private static SortKey sortKey;

	@Override
	public List<Issue> getIssues(User user, int n) throws DAOException {
		sortKey = SortKey.ID;
		sortOrder = SortOrder.ASC;
		List<Issue> issues = getSortedIssues(user, n, sortKey.toString().toLowerCase());
		Collections.sort(issues);
		return issues;
	}

	@Override
	public List<Issue> getSortedIssues(User user, int n, String key)
			throws DAOException {
		SortKey sortKey = SortKey.valueOf(key.toUpperCase());
		if (sortKey == IssueHibernateDAO.sortKey) {
			if (sortOrder == SortOrder.ASC) {
				sortOrder = SortOrder.DESC;
			} else {
				sortOrder = SortOrder.ASC;
			}
		} else {
			sortOrder = SortOrder.ASC;
		}
		IssueHibernateDAO.sortKey = sortKey;
		
		Order order;
		if (sortOrder == SortOrder.ASC){
			order = Order.asc(sortKey.toString().toLowerCase());
		} else {
			order = Order.desc(sortKey.toString().toLowerCase());
		}
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(getDAOClass()).addOrder(order);
			if (user != null) {
				criteria.add(Restrictions.eq("assignee", user));
			}
			criteria.setMaxResults(n);
			return castList(criteria.list());
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	protected Class<Issue> getDAOClass() {
		return Issue.class;
	}
	
}
