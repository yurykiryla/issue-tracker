package org.training.issuetracker.model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.BuildsDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class BuildsJdbcDAO extends JdbcDAO<Build> implements BuildsDAO{
	@Resource(name="jdbc/derbydb")
	private DataSource ds;
	
	public BuildsJdbcDAO() {
	}

	@Override
	public List<Build> getBuilds(int projectId) throws DAOException {
		List<Build> builds = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SELECT_BUILDS_BY_PROJECT_ID);
			ps.setInt(INDEX_ID_SELECT, projectId);
			rs = ps.executeQuery();
			while (rs != null && rs.next()) {
				builds.add(getOb(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(rs, ps, con);
		}
		return builds;
	}

	@Override
	protected String getRequestGetObById() {
		return SELECT_BUILD_BY_ID;
	}

	@Override
	protected String getRequestGetObs() {
		return SELECT_BUILDS;
	}

	@Override
	protected Build getOb(ResultSet rs) throws DAOException, SQLException {
		int id = rs.getInt(INDEX_ID_SELECT);
		String name = rs.getString(INDEX_NAME_SELECT);
		return new Build(id, name);
	}

	@Override
	public void addBuild(Build build, int projectId) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQLRequests.INSERT_BUILD);
			ps.setString(INDEX_NAME_INSERT, build.getName());
			ps.setInt(INDEX_BUILD_PROJECT_ID_INSERT, projectId);
			ps.executeUpdate();			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(ps, con);
		}
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		throw new DAOException(MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, Build ob)
			throws DAOException, SQLException {
		throw new DAOException(MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		throw new DAOException(MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected int getChangedObId() throws DAOException {
		throw new DAOException(MESSAGE_UNSUPPORTED_OPERATION);
	}
	
	
}