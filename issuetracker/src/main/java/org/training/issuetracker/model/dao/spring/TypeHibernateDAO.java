package org.training.issuetracker.model.dao.spring;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exception.DAOException;

@Repository
public class TypeHibernateDAO implements DAO<Type> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Type getOb(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> getObs() throws DAOException {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Type.class).list();
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
