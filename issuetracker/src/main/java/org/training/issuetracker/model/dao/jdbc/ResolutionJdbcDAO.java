/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public class ResolutionJdbcDAO extends JdbcDAO<Resolution> {

	/**
	 * 
	 */
	public ResolutionJdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SQLRequests.SELECT_RESOLUTION_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SQLRequests.SELECT_RESOLUTIONS;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected Resolution getOb(ResultSet resultSet) throws DAOException {
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(Constants.INDEX_ID);
			String name = resultSet.getString(Constants.INDEX_NAME);
			return new Resolution(id, name);
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getPreparedStatement(org.training.issuetracker.model.beans.Beans)
	 */
	@Override
	protected PreparedStatement getPreparedStatement(Resolution ob)
			throws DAOException {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps = getPreparedStatement(SQLRequests.INSERT_RESOLUTION);
			ps.setInt(Constants.INDEX_ID, ob.getId());
			ps.setString(Constants.INDEX_NAME, ob.getName());
			return ps;
		}catch(SQLException e){
			throw new DAOException();
		}
	}

}
