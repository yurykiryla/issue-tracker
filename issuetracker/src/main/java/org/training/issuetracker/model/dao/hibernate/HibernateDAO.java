package org.training.issuetracker.model.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.training.issuetracker.model.bean.Bean;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exception.DAOException;

public abstract class HibernateDAO<T extends Bean> implements DAO<T> {

	@Override
	public T getOb(int id) throws DAOException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return getDAOClass().cast(session.get(getDAOClass(), id));
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<T> getObs() throws DAOException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<?> list = session.createCriteria(getDAOClass()).list();
			return castList(list);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void addOb(T ob) throws DAOException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(ob);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void changeOb(T ob) throws DAOException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(ob);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}		
	}
	
	protected abstract Class<T> getDAOClass();
	
	protected List<T> castList(List<?> list) {
		List<T> obs = new ArrayList<T>();
		for (Object ob : list) {
			obs.add(getDAOClass().cast(ob));
		}
		return obs;
	}
}
