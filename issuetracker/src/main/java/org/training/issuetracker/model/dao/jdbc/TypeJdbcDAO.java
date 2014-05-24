/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public class TypeJdbcDAO extends JdbcDAO<Type> {

	/**
	 * 
	 */
	public TypeJdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SQLRequests.SELECT_TYPE_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SQLRequests.SELECT_TYPES;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected Type getOb(ResultSet resultSet) throws DAOException {
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(Constants.INDEX_ID_SELECT);
			String name = resultSet.getString(Constants.INDEX_NAME_SELECT);
			return new Type(id, name);
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getPreparedStatement(org.training.issuetracker.model.beans.Beans)
	 */
	@Override
	protected PreparedStatement getPreparedStatement(Type ob)
			throws DAOException {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_TYPE);
			ps.setInt(Constants.INDEX_ID_SELECT, ob.getId());
			ps.setString(Constants.INDEX_NAME_SELECT, ob.getName());
			return ps;
		}catch(SQLException e){
			throw new DAOException();
		}
	}
	
}
