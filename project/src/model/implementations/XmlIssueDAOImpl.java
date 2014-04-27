/**
 * 
 */
package model.implementations;

import java.io.IOException;
import java.util.Iterator;

import model.beans.Issue;
import model.constants.Priority;
import model.interfaces.IIssueDAO;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * @author Yury
 *
 */
public class XmlIssueDAOImpl implements IIssueDAO{
	private Iterator<Element> iterator;
	/**
	 * 
	 */
	public XmlIssueDAOImpl() {
		// TODO Auto-generated constructor stub
		try{
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(this.getClass().getClassLoader().getResourceAsStream("resources/Issues.xml"));
			iterator = document.getRootElement().getChildren().iterator();
		}catch(JDOMException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean hasNextIssue() {
		// TODO Auto-generated method stub
		return iterator.hasNext();
	}
	@Override
	public Issue getNextIssue() {
		// TODO Auto-generated method stub
		Element element = iterator.next();
		int id = Integer.parseInt(element.getAttributeValue("id"));
		Priority priority = Priority.valueOf(element.getChildText("priority"));
		
		return null;
	}

}
