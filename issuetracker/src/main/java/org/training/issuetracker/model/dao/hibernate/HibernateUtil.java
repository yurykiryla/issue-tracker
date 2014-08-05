package org.training.issuetracker.model.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
	public static void buildSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
