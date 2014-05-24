package org.training.issuetracker.model.dao;

import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public interface UsersDAO {
	public User getUser(String email, String password) throws DAOException;
}