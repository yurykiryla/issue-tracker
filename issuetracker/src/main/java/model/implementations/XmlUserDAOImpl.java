/**
 * 
 */
package model.implementations;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import model.beans.User;
import model.constants.Constants;
import model.constants.Role;
import model.interfaces.IUserDAO;

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
	 * @see model.interfaces.IUserDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String email, String password) {
		// TODO Auto-generated method stub
		for(Element element : getElements()){
			User user = getUser(element);
			String userEmail = user.getEmailAddress();
			String userPassword = element.getChildText(Constants.KEY_PASSWORD);
			if(email.equals(userEmail) && password.equals(userPassword)){
				return user;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see model.interfaces.IUserDAO#getUser(int)
	 */
	@Override
	public User getUser(int id) {
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
		int id = Integer.parseInt(element.getAttributeValue(Constants.KEY_ID));
		String firstName = element.getChildText(Constants.KEY_FIRST_NAME);
		String lastName = element.getChildText(Constants.KEY_LAST_NAME);
		Role role = Role.valueOf(element.getChildText(Constants.KEY_ROLE));
		String email = element.getChildText(Constants.KEY_EMAIL);
		return new User(id, firstName, lastName, email, role);
	}
	
	private List<Element> getElements(){
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(this.getClass().getClassLoader()
					.getResourceAsStream(Constants.USERS_XML_FILENAME));
			return document.getRootElement().getChildren();
		} catch (JDOMException | IOException e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}
}
