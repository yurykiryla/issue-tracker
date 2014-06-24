package org.training.issuetracker.model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.training.issuetracker.model.bean.Bean;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exception.DAOException;

public abstract class JdbcDAO<T extends Bean> implements DAO<T> {

	protected DataSource ds;
	
	public JdbcDAO() throws DAOException {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/projectdb");
		} catch (NamingException e){
			throw new DAOException(e);
		}
	}

	@Override
	public T getOb(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(getRequestGetObById());
			ps.setInt(Constants.INDEX_ID_SELECT, id);
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				return getOb(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(rs, ps, con);
		}
		return null;
	}

	@Override
	public List<T> getObs() throws DAOException {
		List<T> list = new ArrayList<T>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(getRequestGetObs());
			while (rs != null && rs.next()) {
				list.add(getOb(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(rs, st, con);
		}
		return list;
	}
	
	@Override
	public void addOb(T ob) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(getRequestAddOb());
			ps = getFilledPS(ps, ob);
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(ps, con);
		}
	}

	@Override
	public void changeOb(T ob) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(getRequestChangeOb());
			ps = getFilledPS(ps, ob);
			ps.setInt(getChangedObId(), ob.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(ps, con);
		}
	}

	protected abstract String getRequestGetObById() throws DAOException, org.training.issuetracker.model.dao.exception.DAOException;
	protected abstract String getRequestGetObs() throws DAOException;
	protected abstract T getOb(ResultSet rs) throws DAOException, SQLException;
	protected abstract String getRequestAddOb() throws DAOException;
	protected abstract PreparedStatement getFilledPS(PreparedStatement ps, T ob) throws DAOException, SQLException;
	protected abstract String getRequestChangeOb() throws DAOException;
	protected abstract int getChangedObId() throws DAOException;
	
	protected static void closeConnection(Statement st, Connection con) throws DAOException{
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try{
				if (con != null){
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}
	
	protected static void closeConnection(ResultSet rs, Statement st, Connection con) throws DAOException{
		try{
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(st, con);
		}
	}
}