package org.training.issuetracker.model.dao;

import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;

public interface UserDAO extends DAO<User> {
	public User getUser(String email, String password) throws DAOException;
}
