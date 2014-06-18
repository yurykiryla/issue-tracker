package org.training.issuetracker.model.dao.hibernate;

import org.training.issuetracker.model.bean.Comment;
import org.training.issuetracker.model.dao.exception.DAOException;

public class CommentHibernateDAO extends HibernateDAO<Comment> {
	@Override
	protected Class<Comment> getDAOClass() {
		return Comment.class;
	}

	@Override
	public void changeOb(Comment ob) throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}
	
}
