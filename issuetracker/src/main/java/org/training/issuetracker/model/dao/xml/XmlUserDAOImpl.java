/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.enums.Role;

import static org.training.issuetracker.model.dao.xml.Constants.*; 

/**
 * @author Yury Kiryla
 *
 */
public class XmlUserDAOImpl implements IUserDAO {
	/**
	 * 
	 */
	public XmlUserDAOImpl() {
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IUserDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String email, String password) throws DAOException {
		// TODO Auto-generated method stub
		for(Element element : getElements()){
			User user = getUser(element);
			String userEmail = user.getEmailAddress();
			String userPassword = element.getChildText(KEY_PASSWORD);
			if(email.equals(userEmail) && password.equals(userPassword)){
				return user;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IUserDAO#getUser(int)
	 */
	@Override
	public User getUser(int id) throws DAOException {
		// TODO Auto-generated method stub
		for(Element element : getElements()){
			User user = getUser(element);
			if(id == user.getId()){
				return user;
			}
		}
		return null;
	}

	private User getUser(Element element){
		int id = Integer.parseInt(element.getAttributeValue(KEY_ID));
		String firstName = element.getChildText(KEY_FIRST_NAME);
		String lastName = element.getChildText(KEY_LAST_NAME);
		Role role = Role.valueOf(element.getChildText(KEY_ROLE));
		String email = element.getChildText(KEY_EMAIL);
		return new User(id, firstName, lastName, email, role);
	}
	
	private List<Element> getElements() throws DAOException{
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(this.getClass().getClassLoader()
					.getResourceAsStream(USERS_XML_FILENAME));
			return document.getRootElement().getChildren();
		} catch (JDOMException | IOException e) {
			// TODO: handle exception
			throw new DAOException(e);
		}
	}
}
