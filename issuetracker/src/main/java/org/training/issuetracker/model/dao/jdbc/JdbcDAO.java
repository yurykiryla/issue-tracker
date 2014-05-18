/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.util.List;

import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury
 *
 */
public abstract class JdbcDAO<T extends Beans> implements DAO<T> {

	/**
	 * 
	 */
	public JdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.DAO#getOb(int)
	 */
	@Override
	public T getOb(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.DAO#getObs()
	 */
	@Override
	public List<T> getObs() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected abstract String getRequestOb();
	protected abstract String getRequestObs();
	
	
}
