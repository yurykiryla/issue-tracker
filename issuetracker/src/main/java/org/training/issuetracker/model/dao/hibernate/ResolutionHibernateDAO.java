package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Resolution;

public class ResolutionHibernateDAO extends HibernateDAO<Resolution> {

	@Override
	protected Class<Resolution> getDAOClass() {
		return Resolution.class;
	}
	
}
