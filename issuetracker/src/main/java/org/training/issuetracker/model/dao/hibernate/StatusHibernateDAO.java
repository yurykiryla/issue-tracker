package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Status;
import org.training.issuetracker.model.dao.exception.DAOException;

public class StatusHibernateDAO extends HibernateDAO<Status> {

	@Override
	protected Class<Status> getDAOClass() {
		return Status.class;
	}

	@Override
	public void addOb(Status ob) throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}
	
}
