package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Priority;

public class PriorityHibernateDAO extends HibernateDAO<Priority> {

	@Override
	protected Class<Priority> getDAOClass() {
		return Priority.class;
	}
	
}
