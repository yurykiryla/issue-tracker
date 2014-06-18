package org.training.issuetracker.model.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.password.Password;

public class UserHibernateDAO extends HibernateDAO<User> implements UserDAO {

	@Override
	public User getUser(String email, String password) throws DAOException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<?> list = session.createCriteria(getDAOClass()).add(Restrictions.eq("email", email)).list();
			User user = null;
			if (!list.isEmpty()) {
				User tmpUser = (User) list.get(0);
				if (tmpUser.getPassword().equals(Password.encode(password))) {
					user = tmpUser;
				}
			}
			return user;
		} catch (HibernateException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	protected Class<User> getDAOClass() {
		return User.class;
	}

}
