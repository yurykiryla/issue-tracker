/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			int id = resultSet.getInt(INDEX_ID);
			
			Priority priority = DAOFactory.getPriorityDAO().getOb(resultSet.getInt(INDEX_PRIORITY_ID));
			
			DAO<User> userDAO = DAOFactory.getUserDAO();
			User assignee = userDAO.getOb(INDEX_ASSIGNEE_ID);
			
			Type type = DAOFactory.getTypeDAO().getOb(resultSet.getInt(INDEX_TYPE_ID));
			
			Status status = DAOFactory.getStatusDAO().getOb(resultSet.getInt(INDEX_STATUS_ID));
			
			String summary = resultSet.getString(INDEX_SUMMARY);
			
			String description = resultSet.getString(INDEX_ISSUE_DESCRIPTION);
			
			Project project = DAOFactory.getProjectDAO().getOb(resultSet.getInt(INDEX_ISSUE_PROJECT_ID));
			
			String buildFound = resultSet.getString(INDEX_BUILD_FOUND);
			
			Date createDate = resultSet.getDate(INDEX_CREATE_DATE);
			
			User createdBy = userDAO.getOb(resultSet.getInt(INDEX_CREATED_BY_ID));
			
			Date modifyDate = resultSet.getDate(INDEX_MODIFY_DATE);
			
			User modifiedBy = userDAO.getOb(resultSet.getInt(INDEX_MODIFIED_BY_ID));
			
			Resolution resolution = DAOFactory.getResolutionDAO().getOb(resultSet.getInt(INDEX_RESOLUTION_ID));
			
			return new Issue(id, priority, assignee, type, status, summary, description, project,
					buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}

}
