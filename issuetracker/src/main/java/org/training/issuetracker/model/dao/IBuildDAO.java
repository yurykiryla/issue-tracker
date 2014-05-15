/**
 * 
 */
package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public interface IBuildDAO {
	public Build getBuild(int id) throws DAOException;
	public List<Build> getBuilds(int projectId) throws DAOException;
}
