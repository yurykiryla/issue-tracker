/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury
 *
 */
public class ProjectXmlDAO extends XmlDAO<Project>{

	/**
	 * 
	 */
	public ProjectXmlDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getFilename()
	 */
	@Override
	protected String getFilename() {
		// TODO Auto-generated method stub
		return PROJECTS_XML_FILENAME;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getOb(org.jdom2.Element)
	 */
	@Override
	protected Project getOb(Element element) throws DAOException {
		// TODO Auto-generated method stub
		int id = getId(element);
		String name = element.getChildText(KEY_NAME);
		String description = element.getChildText(KEY_DESCRIPTION);
		List<String> builds = new ArrayList<>();
		List<Element> buildElements = element.getChildren(KEY_BUILS);
		for(Element buildElement : buildElements){
			builds.add(buildElement.getChildText(KEY_BUILD));
		}
		User manager = DAOFactory.getUserDAO().getOb(Integer.parseInt(element.getChildText(KEY_MANAGER_ID)));
		return new Project(id, name, description, builds, manager);
	}

}
