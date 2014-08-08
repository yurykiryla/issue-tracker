package org.training.issuetracker.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exception.DAOException;

@org.springframework.stereotype.Service
public class TypeService implements Service<Type> {

	@Autowired
	private DAO<Type> typeDao;
	
	@Override
	public Type getOb(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Type> getObs() throws DAOException {
		return typeDao.getObs();
	}

	@Override
	public void addOb(Type ob) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeOb(Type ob) throws DAOException {
		// TODO Auto-generated method stub

	}

}
