/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.IIssueDAO;
import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.BuildFactory;
import org.training.issuetracker.model.dao.factories.ProjectFactory;
import org.training.issuetracker.model.dao.factories.UserFactory;
import org.training.issuetracker.model.enums.Priority;
import org.training.issuetracker.model.enums.Resolution;
import org.training.issuetracker.model.enums.Status;
import org.training.issuetracker.model.enums.Type;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

/**
 * @author Yury
 *
 */
public class SQLIssueDAOImpl implements IIssueDAO {

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IIssueDAO#getIssues(org.training.issuetracker.model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) throws DAOException{
		// TODO Auto-generated method stub
		List<Issue> issues = new ArrayList<>();
		try(DBConnection dbConnection = new DBConnection()){
			Statement statement = dbConnection.getStatement();
			statement.setMaxRows(n);
			ResultSet resultSet;
			if(user == null){
				resultSet = statement.executeQuery(SELECT_DEFAULT_ISSUES);
			}else{
				resultSet = statement.executeQuery(SELECT_ASSIGNEE_ISSUES + user.getId());
			}
			while(resultSet != null && resultSet.next()){
				int id = resultSet.getInt(INDEX_ID);
				
				Priority priority = Priority.valueOf(resultSet.getString(INDEX_PRIORITY));
				
				IUserDAO userDAO = UserFactory.getClassFromFactory();
				User assignee = null;
				int assigneeId = resultSet.getInt(INDEX_ASSIGNEE_ID);
				if(assigneeId != 0){
					assignee = userDAO.getUser(assigneeId);
				}
				
				Type type = Type.valueOf(resultSet.getString(INDEX_TYPE));
				
				Status status = Status.valueOf(resultSet.getString(INDEX_STATUS));
				
				String summary = resultSet.getString(INDEX_SUMMARY);
				
				String description = resultSet.getString(INDEX_DESCRIPTION);
				
				Project project = ProjectFactory.getClassFromFactory()
						.getProject(resultSet.getInt(INDEX_PROJECT_ID));
				
				Build buildFound = BuildFactory.getClassFromFactory()
						.getBuild(resultSet.getInt(INDEX_BUILD_FOUND_ID));
				
				Date createDate = resultSet.getDate(INDEX_CREATE_DATE);
				
				User createdBy = userDAO.getUser(resultSet.getInt(INDEX_CREATED_BY_ID));
				
				Date modifyDate = resultSet.getDate(INDEX_MODIFY_DATE);

				User modifiedBy = null;
				int modifiedById = resultSet.getInt(INDEX_MODIFIED_BY_ID);
				if(modifiedById != 0){
					modifiedBy = userDAO.getUser(modifiedById);
				}
				
				Resolution resolution = null;
				String resolutionStr = resultSet.getString(INDEX_RESOLUTION);
				if(resolutionStr != null){
					resolution = Resolution.valueOf(resolutionStr);
				}
				
				issues.add(new Issue(id, priority, assignee, type, status, summary, description, project, 
						buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution));
			}
			if(resultSet != null){
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		return issues;
	}

}
