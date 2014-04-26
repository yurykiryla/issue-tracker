/**
 * 
 */
package model.implementations;

import java.io.IOException;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import model.beans.User;
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
		User user = null;
		try{
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(this.getClass().getClassLoader().getResourceAsStream("resources/Users.xml"));
			Element rootElement = document.getRootElement();
			Iterator<Element> iterator = rootElement.getChildren().iterator();
			while(iterator.hasNext()){
				Element userElement = iterator.next();
				String userEmail = userElement.getAttributeValue("email");
				String userPassword = userElement.getChildText("password");
				if(email.equals(userEmail) && password.equals(userPassword)){
					String firstName = userElement.getChildText("first-name");
					String lastName = userElement.getChildText("last-name");
					Role role = Role.valueOf(userElement.getChildText("role"));
					user = new User(firstName, lastName, userEmail, role);
					break;
				}
			}
		}catch(JDOMException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return user;
	}

}
