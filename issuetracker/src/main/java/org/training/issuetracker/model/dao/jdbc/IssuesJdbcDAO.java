package org.training.issuetracker.model.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssuesDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;
import org.training.issuetracker.model.issues.sort.SortKeys;
import org.training.issuetracker.model.issues.sort.SortOrders;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class IssuesJdbcDAO extends JdbcDAO<Issue> implements IssuesDAO {
	private static SortKeys sortKey;
	private static SortOrders sortOrder;
	@Resource(name="jdbc/derbydb")
	private DataSource ds;
	
	@Override
	public List<Issue> getIssues(User user, int n) throws DAOException {
		sortKey = SortKeys.CREATE_DATE;
		sortOrder = SortOrders.ASK;
		return getSortedIssues(user, n, KEY_DEFAULT_SORT);
	}

	@Override
	public List<Issue> getSortedIssues(User user, int n, String key)
			throws DAOException {
		List<Issue> issues = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			st = con.createStatement();
			st.setMaxRows(n);
			SortKeys sortKey = SortKeys.valueOf(key.toUpperCase());
			if (sortKey == IssuesJdbcDAO.sortKey) {
				if (sortOrder == SortOrders.ASK) {
					sortOrder = SortOrders.DESK;
				} else {
					sortOrder = SortOrders.ASK;
				}
			} else {
				sortOrder = SortOrders.ASK;
			}
			IssuesJdbcDAO.sortKey = sortKey;
			rs = st.executeQuery(SELECT_SORTED_ISSUES + sortKey + " " + sortOrder);
			while (rs != null && rs.next()) {
				issues.add(getOb(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(rs, st, con);
		}
		return issues;
	}

	@Override
	protected String getRequestGetObById() throws DAOException {
		return SELECT_ISSUE_BY_ID;
	}

	@Override
	protected String getRequestGetObs() throws DAOException {
		return SELECT_ISSUES;
	}

	@Override
	protected Issue getOb(ResultSet rs) throws DAOException,
			SQLException {
		int id = rs.getInt(INDEX_ID_SELECT);
		
		Priority priority = DAOFactory.getPriorityDAO().getOb(rs.getInt(INDEX_PRIORITY_ID_SELECT));
		
		DAO<User> userDAO = DAOFactory.getUserDAO();
		User assignee = userDAO.getOb(rs.getInt(INDEX_ASSIGNEE_ID_SELECT));
		
		Type type = DAOFactory.getTypeDAO().getOb(rs.getInt(INDEX_TYPE_ID_SELECT));
		
		Status status = DAOFactory.getStatusDAO().getOb(rs.getInt(INDEX_STATUS_ID_SELECT));
		
		String summary = rs.getString(INDEX_SUMMARY_SELECT);
		
		String description = rs.getString(INDEX_ISSUE_DESCRIPTION_SELECT);
		
		Project project = DAOFactory.getProjectDAO().getOb(rs.getInt(INDEX_ISSUE_PROJECT_ID_SELECT));
			
		Build buildFound = DAOFactory.getBuildDAO().getOb(Integer.parseInt(rs.getString(INDEX_BUILD_FOUND_SELECT)));
			
		Date createDate = rs.getDate(INDEX_CREATE_DATE_SELECT);
			
		User createdBy = userDAO.getOb(rs.getInt(INDEX_CREATED_BY_ID_SELECT));
			
		Date modifyDate = rs.getDate(INDEX_MODIFY_DATE_SELECT);
			
		User modifiedBy = userDAO.getOb(rs.getInt(INDEX_MODIFIED_BY_ID_SELECT));
			
		Resolution resolution = DAOFactory.getResolutionDAO().getOb(rs.getInt(INDEX_RESOLUTION_ID_SELECT));
			
		return new Issue(id, priority, assignee, type, status, summary, description, project,
				buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
	}

	@Override
	protected String getRequestAddOb() throws DAOException {
		return INSERT_ISSUE;
	}

	@Override
	protected PreparedStatement getFilledPS(PreparedStatement ps, Issue ob)
			throws DAOException, SQLException {
		ps.setInt(INDEX_PRIORITY_ID_INSERT, ob.getPriority().getId());
		User assignee = ob.getAssignee();
		if (assignee != null) {
			ps.setInt(INDEX_ASSIGNEE_ID_INSERT, assignee.getId());
		} else {
			ps.setNull(INDEX_ASSIGNEE_ID_INSERT, Types.INTEGER);
		}
		ps.setInt(INDEX_TYPE_ID_INSERT, ob.getType().getId());
		ps.setInt(INDEX_STATUS_ID_INSERT, ob.getStatus().getId());
		ps.setString(INDEX_SUMMARY_INSERT, ob.getSummary());
		ps.setString(INDEX_ISSUE_DESCRIPTION_INSERT, ob.getDescription());
		ps.setInt(INDEX_ISSUE_PROJECT_ID_INSERT, ob.getProject().getId());
		ps.setInt(INDEX_BUILD_FOUND_INSERT, ob.getBuildFound().getId());
		ps.setDate(INDEX_CREATE_DATE_INSERT, ob.getCreateDate());
		ps.setInt(INDEX_CREATED_BY_ID_INSERT, ob.getCreatedBy().getId());
		ps.setDate(INDEX_MODIFY_DATE_INSERT, ob.getModifyDate());
		User modifiedBy = ob.getModifiedBy();
		if (modifiedBy != null) {
			ps.setInt(INDEX_MODIFIED_BY_ID_INSERT, modifiedBy.getId());
		} else {
			ps.setNull(INDEX_MODIFIED_BY_ID_INSERT, Types.INTEGER);
		}
		Resolution resolution = ob.getResolution();
		if (resolution != null) {
			ps.setInt(INDEX_RESOLUTION_ID_INSERT, resolution.getId());
		} else {
			ps.setNull(INDEX_RESOLUTION_ID_INSERT, Types.INTEGER);
		}
		return ps;
	}

	@Override
	protected String getRequestChangeOb() throws DAOException {
		return UPDATE_ISSUE;
	}

	@Override
	protected int getChangedObId() {
		return INDEX_ID_ISSUE;
	}
}