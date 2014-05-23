/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.BuildsDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

/**
 * @author Yury Kiryla
 *
 */
public class BuildsJdbcDAO extends JdbcDAO<Build> implements BuildsDAO{

	/**
	 * 
	 */
	public BuildsJdbcDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.BuildsDAO#getBuilds(int)
	 */
	@Override
	public List<Build> getBuilds(int projectId) throws DAOException {
		// TODO Auto-generated method stub
		List<Build> builds = new ArrayList<>();
		try{
			resultSet = getResultSet(SELECT_BUILDS_BY_PROJECT_ID + projectId);
			while(resultSet != null && resultSet.next()){
				builds.add(getOb(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		return builds;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SELECT_BUILD_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SELECT_BUILDS;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected Build getOb(ResultSet resultSet) throws DAOException {
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(INDEX_ID);
			String name = resultSet.getString(INDEX_NAME);
			return new Build(id, name);
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}
}
