/**
 * 
 */
package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.exceptions.DAOException;

/**
 * @author Yury
 *
 */
public interface DAO<T extends Beans> {
	public T getOb(int id) throws DAOException;
	public List<T> getObs() throws DAOException;
	//public void addOb(T ob) throws DAOException;
}
