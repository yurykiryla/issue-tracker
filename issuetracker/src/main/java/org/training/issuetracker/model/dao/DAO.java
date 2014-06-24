package org.training.issuetracker.model.dao;

import java.util.List;

import org.training.issuetracker.model.bean.Bean;
import org.training.issuetracker.model.dao.exception.DAOException;


public interface DAO<T extends Bean> {
	public T getOb(int id) throws DAOException;
	public List<T> getObs() throws DAOException;
	public void addOb(T ob) throws DAOException;
	public void changeOb(T ob) throws DAOException;
}
