/**
 * 
 */
package org.training.issuetracker.model.dao;

import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury Kiryla
 *
 */
public interface IProjectDAO{
	public Project getProject(int id) throws DAOException;
}
