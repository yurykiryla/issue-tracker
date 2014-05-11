/**
 * 
 */
package model.implementations;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.beans.Issue;
import model.beans.Project;
import model.beans.User;
import model.constants.Constants;
import model.constants.Priority;
import model.constants.Resolution;
import model.constants.SQLRequests;
import model.constants.Status;
import model.constants.Type;
import model.db.DBConnection;
import model.factories.UserFactory;
import model.interfaces.IIssueDAO;
import model.interfaces.IUserDAO;

/**
 * @author Yury
 *
 */
public class SQLIssueDAOImpl implements IIssueDAO {

	/* (non-Javadoc)
	 * @see model.interfaces.IIssueDAO#getIssues(model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) {
		// TODO Auto-generated method stub
		List<Issue> issues = new ArrayList<>();
		try(DBConnection dbConnection = new DBConnection()){
			Statement statement = dbConnection.getConnection().createStatement();
			statement.setMaxRows(n);
			ResultSet resultSet;
			if(user == null){
				resultSet = statement.executeQuery(SQLRequests.SELECT_DEFAULT_ISSUES);
			}else{
				resultSet = statement.executeQuery(SQLRequests.SELECT_ASSEGNEE_ISSUES + user.getId());
			}
			while(resultSet.next()){
				int id = resultSet.getInt(Constants.INDEX_ID);
				
				Priority priority = Priority.valueOf(resultSet.getString(Constants.INDEX_PRIORITY));
				
				IUserDAO userDAO = UserFactory.getClassFromFactory();
				User assignee = null;
				int assigneeId = resultSet.getInt(Constants.INDEX_ASSIGNEE_ID);
				if(assigneeId != 0){
					assignee = userDAO.getUser(assigneeId);
				}
				
				Type type = Type.valueOf(resultSet.getString(Constants.INDEX_TYPE));
				
				Status status = Status.valueOf(resultSet.getString(Constants.INDEX_STATUS));
				
				String summary = resultSet.getString(Constants.INDEX_SUMMARY);
				
				String description = resultSet.getString(Constants.INDEX_DESCRIPTION);
				
				Project project = new Project(resultSet.getInt(Constants.INDEX_PROJECT_ID), null, null, null, null);
				
				String buildFound = resultSet.getString(Constants.INDEX_BUILD_FOUND_ID);
				
				Date createDate = resultSet.getDate(Constants.INDEX_CREATE_DATE);
				
				User createdBy = userDAO.getUser(resultSet.getInt(Constants.INDEX_CREATED_BY_ID));
				
				Date modifyDate = resultSet.getDate(Constants.INDEX_MODIFY_DATE);

				User modifiedBy = null;
				int modifiedById = resultSet.getInt(Constants.INDEX_MODIFIED_BY_ID);
				if(modifiedById != 0){
					modifiedBy = userDAO.getUser(modifiedById);
				}
				
				Resolution resolution = null;
				String resolutionStr = resultSet.getString(Constants.INDEX_RESOLUTION);
				if(resolutionStr != null){
					resolution = Resolution.valueOf(resolutionStr);
				}
				
				issues.add(new Issue(id, priority, assignee, type, status, summary, description, project, 
						buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution));
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		return issues;
	}

}
