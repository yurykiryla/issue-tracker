/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;
/**
 * @author Yury Kiryla
 *
 */
public class IssuesJdbcDAO extends JdbcDAO<Issue> implements IssuesDAO {
	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IssuesDAO#getIssues(org.training.issuetracker.model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) throws DAOException {
		// TODO Auto-generated method stub
		String request;
		if(user == null){
			request = SELECT_N_LAST_ISSUES;
		}else{
			request = SELECT_N_ASSIGNED_ISSUES_1 + user.getId() + SELECT_N_ASSIGNED_ISSUES_2;
		}
		resultSet = getResultSet(request + n);
		List<Issue> issues = new ArrayList<>();
		try{
			while(resultSet != null && resultSet.next()){
				issues.add(getOb(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			closeConnection();
		}
		return issues;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestOb()
	 */
	@Override
	protected String getRequestOb() {
		// TODO Auto-generated method stub
		return SELECT_ISSUE_BY_ID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getRequestObs()
	 */
	@Override
	protected String getRequestObs() {
		// TODO Auto-generated method stub
		return SELECT_ISSUES;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getOb(java.sql.ResultSet)
	 */
	@Override
	protected Issue getOb(ResultSet resultSet) throws DAOException{
		// TODO Auto-generated method stub
		try{
			int id = resultSet.getInt(INDEX_ID_SELECT);
			
			Priority priority = DAOFactory.getPriorityDAO().getOb(resultSet.getInt(INDEX_PRIORITY_ID_SELECT));
			
			DAO<User> userDAO = DAOFactory.getUserDAO();
			User assignee = userDAO.getOb(resultSet.getInt(INDEX_ASSIGNEE_ID_SELECT));
			
			Type type = DAOFactory.getTypeDAO().getOb(resultSet.getInt(INDEX_TYPE_ID_SELECT));
			
			Status status = DAOFactory.getStatusDAO().getOb(resultSet.getInt(INDEX_STATUS_ID_SELECT));
			
			String summary = resultSet.getString(INDEX_SUMMARY_SELECT);
			
			String description = resultSet.getString(INDEX_ISSUE_DESCRIPTION_SELECT);
			
			Project project = DAOFactory.getProjectDAO().getOb(resultSet.getInt(INDEX_ISSUE_PROJECT_ID_SELECT));
			
			Build buildFound = DAOFactory.getBuildDAO().getOb(Integer.parseInt( resultSet.getString(INDEX_BUILD_FOUND_SELECT)));
			
			Date createDate = resultSet.getDate(INDEX_CREATE_DATE_SELECT);
			
			User createdBy = userDAO.getOb(resultSet.getInt(INDEX_CREATED_BY_ID_SELECT));
			
			Date modifyDate = resultSet.getDate(INDEX_MODIFY_DATE_SELECT);
			
			User modifiedBy = userDAO.getOb(resultSet.getInt(INDEX_MODIFIED_BY_ID_SELECT));
			
			Resolution resolution = DAOFactory.getResolutionDAO().getOb(resultSet.getInt(INDEX_RESOLUTION_ID_SELECT));
			
			return new Issue(id, priority, assignee, type, status, summary, description, project,
					buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
		}catch(SQLException e){
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.jdbc.JdbcDAO#getPreparedStatement(org.training.issuetracker.model.beans.Beans)
	 */
	@Override
	protected PreparedStatement getPreparedStatement(Issue ob)
			throws DAOException {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps = getPreparedStatement(INSERT_ISSUE);
			//ps.setInt(INDEX_ID_SELECT, ob.getId());
			ps.setInt(INDEX_PRIORITY_ID_SELECT, ob.getPriority().getId());
			User assignee = ob.getAssignee();
			if(assignee != null){
				ps.setInt(INDEX_ASSIGNEE_ID_SELECT, assignee.getId());
			}else{
				ps.setNull(INDEX_ASSIGNEE_ID_SELECT, Types.INTEGER);
			}
			ps.setInt(INDEX_TYPE_ID_SELECT, ob.getType().getId());
			ps.setInt(INDEX_STATUS_ID_SELECT, ob.getStatus().getId());
			ps.setString(INDEX_SUMMARY_SELECT, ob.getSummary());
			ps.setString(INDEX_ISSUE_DESCRIPTION_SELECT, ob.getDescription());
			ps.setInt(INDEX_ISSUE_PROJECT_ID_SELECT, ob.getProject().getId());
			ps.setInt(INDEX_BUILD_FOUND_SELECT, ob.getBuildFound().getId());
			ps.setDate(INDEX_CREATE_DATE_SELECT, ob.getCreateDate());
			ps.setInt(INDEX_CREATED_BY_ID_SELECT, ob.getCreatedBy().getId());
			ps.setDate(INDEX_MODIFY_DATE_SELECT, ob.getModifyDate());
			User modifiedBy = ob.getModifiedBy();
			if(modifiedBy != null){
				ps.setInt(INDEX_MODIFIED_BY_ID_SELECT, modifiedBy.getId());
			}else{
				ps.setNull(INDEX_MODIFIED_BY_ID_SELECT, Types.INTEGER);
			}
			Resolution resolution = ob.getResolution();
			if(resolution != null){
				ps.setInt(INDEX_RESOLUTION_ID_SELECT, resolution.getId());
			}else{
				ps.setNull(INDEX_RESOLUTION_ID_SELECT, Types.INTEGER);
			}
			return ps;
		}catch(SQLException e){
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

}
