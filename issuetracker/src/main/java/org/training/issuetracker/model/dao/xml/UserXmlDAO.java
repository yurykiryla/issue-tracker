package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.UserDAO;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.xml.Constants.*;

public class UserXmlDAO extends XmlDAO<User> implements UserDAO {
	@Override
	public User getUser(String email, String password) throws DAOException {
		for (User user : getObs()) {
			if (user.getEmail().equals(email) && user.getPassword() == password) {
				return user;
			}
		}
		return null;
	}

	@Override
	protected String getFilename() {
		return USERS_XML_FILENAME;
	}

	@Override
	protected User getOb(Element element) throws DAOException {
		int id = getId(element);
		String firstName = element.getChildText(KEY_FIRST_NAME);
		String lastName = element.getChildText(KEY_LAST_NAME);
		Role role = Role.valueOf(element.getChildText(KEY_ROLE));
		String email = element.getChildText(KEY_EMAIL);
		return new User();
	}
}