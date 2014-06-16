package org.training.issuetracker.model.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.training.issuetracker.model.beans.Beans;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

public class HibernateDAO<T extends Beans> implements DAO<T>{
	private static final SessionFactory SESSION_FACTORY;
	
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public HibernateDAO() {
		
	}

	@Override
	public T getOb(int id) throws DAOException {
		Session session = null;
		try {
			session = SESSION_FACTORY.openSession();
			return (T) session.load(getClass(), id);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<T> getObs() throws DAOException {
		Session session = null;
		try {
			session = SESSION_FACTORY.openSession();
			return session.createCriteria(getClass()).list();
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addOb(T ob) throws DAOException {
		Session session = null;
		try {
			session = SESSION_FACTORY.openSession();
			session.beginTransaction();
			session.save(ob);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void changeOb(T ob) throws DAOException {
		Session session = null;
		try {
			session = SESSION_FACTORY.openSession();
			session.beginTransaction();
			session.update(ob);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
	}

}
