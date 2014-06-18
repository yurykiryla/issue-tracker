package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.dao.exception.DAOException;

public class BuildHibernateDAO extends HibernateDAO<Build> {

	@Override
	public void changeOb(Build ob) throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected Class<Build> getDAOClass() {
		return Build.class;
	}
	
}
