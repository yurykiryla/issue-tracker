package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Type;

public class TypeHibernateDAO extends HibernateDAO<Type> {

	@Override
	protected Class<Type> getDAOClass() {
		return Type.class;
	}
	
}
