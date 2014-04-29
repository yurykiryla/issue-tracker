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

import model.beans.Issue;
import model.beans.User;
import model.interfaces.IIssueDAO;

/**
 * @author Yury Kiryla
 *
 */
public class XmlIssueDAOImpl implements IIssueDAO{

	/* (non-Javadoc)
	 * @see model.interfaces.IIssueDAO#getIssues(model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) {
		// TODO Auto-generated method stub
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(this.getClass().getClassLoader().getResourceAsStream("resources/Issues.xml"));
			List<Element> allIssues = document.getRootElement().getChildren();
		} catch (JDOMException | IOException e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
		return null;
	}
	
}
