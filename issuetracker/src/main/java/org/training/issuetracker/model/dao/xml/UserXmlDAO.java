package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Password;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.UsersDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.xml.Constants.*;

public class UserXmlDAO extends XmlDAO<User> implements UsersDAO {
	@Override
	public User getUser(String email, String password) throws DAOException {
		for (User user : getObs()) {
			if (user.getEmailAddress().equals(email) && user.getPassword().checkPassword(password)) {
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
		Password password = new Password();
		password.setEncryptedPassword(element.getChildText(KEY_PASSWORD));
		return new User(id, firstName, lastName, email, role, password);
	}
}