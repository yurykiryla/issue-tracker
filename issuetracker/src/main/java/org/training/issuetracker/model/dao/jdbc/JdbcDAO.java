/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury
 *
 */
public abstract class JdbcDAO<T extends Beans> implements DAO<T> {
	private DBConnection dbConnection = null;
	protected ResultSet resultSet = null;
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
		try{
			resultSet = getResultSet(getRequestOb() + id);
			if(resultSet != null && resultSet.next()){
				return getOb(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.DAO#getObs()
	 */
	@Override
	public List<T> getObs() throws DAOException {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<>();
		try {
			resultSet = getResultSet(getRequestObs());
			while(resultSet != null && resultSet.next()){
				list.add(getOb(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		} finally {
			closeConnection();
		}
		return list;
	}
	
	protected abstract String getRequestOb();
	protected abstract String getRequestObs();
	protected abstract T getOb(ResultSet resultSet) throws DAOException;
	
	protected ResultSet getResultSet(String SQLRequest) throws DAOException{
		dbConnection = new DBConnection();
		Statement statement = dbConnection.getStatement();
		try {
			return statement.executeQuery(SQLRequest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
	}
	
	protected void closeConnection() throws DAOException{
		try{
			if(resultSet != null){
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}finally{
			if(dbConnection != null){
				dbConnection.close();
			}
		}
	}
}
