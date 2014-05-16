/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.IProjectDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.BuildFactory;
import org.training.issuetracker.model.dao.factories.UserFactory;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;
/**
 * @author Оля
 *
 */
public class SQLProjectDAOImpl implements IProjectDAO {

	/**
	 * 
	 */
	public SQLProjectDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IProjectDAO#getProject(int)
	 */
	@Override
	public Project getProject(int id) throws DAOException {
		// TODO Auto-generated method stub
		Project project = null;
		try(DBConnection dbConnection = new DBConnection()){
			Statement statement = dbConnection.getStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_PROJECT_BY_ID + id);
			if(resultSet != null && resultSet.next()){
				String name = resultSet.getString(INDEX_NAME);
				String description = resultSet.getString(INDEX_DESCRIPTION);
				List<Build> builds = BuildFactory.getClassFromFactory().getBuilds(id);
				User manager = UserFactory.getClassFromFactory()
						.getUser(resultSet.getInt(INDEX_MANAGER_ID));
				project = new Project(id, name, description, builds, manager);
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		return project;
	}

}
