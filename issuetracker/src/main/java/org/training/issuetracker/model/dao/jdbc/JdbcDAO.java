package org.training.issuetracker.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public abstract class JdbcDAO<T extends Beans> implements DAO<T> {
	private DBConnection dbConnection = null;
	protected ResultSet resultSet = null;
	
	public JdbcDAO() {
	}

	@Override
	public T getOb(int id) throws DAOException {
		try {
			resultSet = getResultSet(getRequestOb() + id);
			if (resultSet != null && resultSet.next()) {
				return getOb(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public List<T> getObs() throws DAOException {
		List<T> list = new ArrayList<>();
		try {
			resultSet = getResultSet(getRequestObs());
			while (resultSet != null && resultSet.next()) {
				list.add(getOb(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection();
		}
		return list;
	}
	
	@Override
	public void addOb(T ob) throws DAOException {
		try {
			getPreparedStatementAddOb(ob).executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}		
	}

	@Override
	public void changeOb(T ob) throws DAOException {
		try {
			getPreparedStatementChangeOb(ob).executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	protected abstract String getRequestOb();
	protected abstract String getRequestObs();
	protected abstract T getOb(ResultSet resultSet) throws DAOException, SQLException;
	protected abstract PreparedStatement getPreparedStatementAddOb(T ob) throws DAOException, SQLException;
	protected abstract PreparedStatement getPreparedStatementChangeOb(T ob) throws DAOException, SQLException;
	
	protected PreparedStatement getPreparedStatement(String SQLRequest) 
			throws DAOException, SQLException {
		dbConnection = new DBConnection();
		return dbConnection.getConnection().prepareStatement(SQLRequest);
	}
	
	protected ResultSet getResultSet(String SQLRequest) throws DAOException, SQLException{
		dbConnection = new DBConnection();
		Statement statement = dbConnection.getStatement();
		return statement.executeQuery(SQLRequest);
	}
	
	protected void closeConnection() throws DAOException{
		try{
			if(resultSet != null){
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			if(dbConnection != null){
				try {
					dbConnection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
	}
}