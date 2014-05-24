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
	private int projectId = 0;
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
			int id = resultSet.getInt(INDEX_ID_SELECT);
			String name = resultSet.getString(INDEX_NAME_SELECT);
			return new Build(id, name);
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#addOb(org.training.issuetracker.model.beans.Beans)
	 */
	@Override
	public void addOb(Build ob) throws DAOException {
		// TODO Auto-generated method stub
		throw new DAOException();
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getPreparedStatement(org.training.issuetracker.model.beans.Beans)
	 */
	@Override
	protected PreparedStatement getPreparedStatement(Build ob)
			throws DAOException {
		// TODO Auto-generated method stub
		if(projectId != 0){
			try{
				PreparedStatement ps = getPreparedStatement(INSERT_BUILD);
				ps.setString(INDEX_NAME_INSERT, ob.getName());
				ps.setInt(INDEX_BUILD_PROJECT_ID_INSERT, projectId);
				return ps;
			}catch(SQLException e){
				throw new DAOException();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.BuildsDAO#addBuild(org.training.issuetracker.model.beans.Build, int)
	 */
	@Override
	public void addBuild(Build build, int projectId) throws DAOException {
		// TODO Auto-generated method stub
		this.projectId = projectId;
		super.addOb(build);
	}
	
	
}
