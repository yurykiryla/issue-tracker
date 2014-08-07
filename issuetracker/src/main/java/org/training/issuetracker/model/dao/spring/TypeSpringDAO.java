package org.training.issuetracker.model.dao.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exception.DAOException;

@Service
public class TypeSpringDAO implements TypeDAO {

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
		// TODO Auto-generated method stub
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
