package org.training.issuetracker.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.IBuildDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

import static org.training.issuetracker.model.dao.jdbc.Constants.*;
import static org.training.issuetracker.model.dao.jdbc.SQLRequests.*;

public class SQLBuildDAOImpl implements IBuildDAO {

	public SQLBuildDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Build getBuild(int id) throws DAOException {
		// TODO Auto-generated method stub
		Build build = null;
		try(DBConnection dbConnection = new DBConnection()){
			ResultSet resultSet = dbConnection.getStatement().executeQuery(SELECT_BUILD_BY_ID + id);
			if(resultSet != null && resultSet.next()){
				String buildStr = resultSet.getString(INDEX_BUILD);
				build = new Build(id, buildStr);
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return build;
	}

	@Override
	public List<Build> getBuilds(int projectId) throws DAOException {
		// TODO Auto-generated method stub
		List<Build> builds = new ArrayList<>();
		try(DBConnection dbConnection = new DBConnection()){
			ResultSet resultSet = dbConnection.getStatement()
					.executeQuery(SELECT_BUILDS_BY_PROJECT_ID + projectId);
			while(resultSet != null && resultSet.next()){
				int id = resultSet.getInt(INDEX_ID);
				String buildStr = resultSet.getString(INDEX_BUILD);
				builds.add(new Build(id, buildStr));
			}
			if(resultSet != null){
				resultSet.close();
			}			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return builds;
	}
}
