package org.training.issuetracker.model.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.dao.BuildDAO;
import org.training.issuetracker.model.dao.exception.DAOException;

public class BuildHibernateDAO extends HibernateDAO<Build> implements BuildDAO {

	@Override
	public void changeOb(Build ob) throws DAOException {
		throw new DAOException(Constants.MESSAGE_UNSUPPORTED_OPERATION);
	}

	@Override
	protected Class<Build> getDAOClass() {
		return Build.class;
	}

	@Override
	public List<Build> getBuilds(Project project) throws DAOException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<?> list = session.createCriteria(getDAOClass()).add(Restrictions.eq("project", project)).list();
			return castList(list);
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
