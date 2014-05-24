/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public class PriorityJdbcDAO extends JdbcDAO<Priority>{

	/**
	 * 
	 */
	public PriorityJdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SQLRequests.SELECT_PRIORITY_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SQLRequests.SELECT_PRIORITIES;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected Priority getOb(ResultSet resultSet) throws DAOException {
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(Constants.INDEX_ID_SELECT);
			String name = resultSet.getString(Constants.INDEX_NAME_SELECT);
			return new Priority(id, name);
		}catch(SQLException e){
			throw new DAOException(e);
		}	
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getPreparedStatement(org.training.issuetracker.model.beans.Beans)
	 */
	@Override
	protected PreparedStatement getPreparedStatement(Priority ob)
			throws DAOException {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_PRIORITY);
			ps.setString(Constants.INDEX_NAME_INSERT, ob.getName());
			return ps;
		}catch(SQLException e){
			throw new DAOException();
		}
	}
	
	
}
