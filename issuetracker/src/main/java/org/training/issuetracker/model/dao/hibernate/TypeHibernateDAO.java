package org.training.issuetracker.model.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.training.issuetracker.model.bean.Type;

@Repository
public class TypeHibernateDAO extends HibernateDAO<Type> {

	@Override
	protected Class<Type> getDAOClass() {
		return Type.class;
	}
	
}
