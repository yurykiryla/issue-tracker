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
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.IProjectDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.BuildFactory;
import org.training.issuetracker.model.dao.factories.UserFactory;
import org.training.issuetracker.model.properties.Config;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury Kiryla
 *
 */
public class XmlProjectDAOImpl implements IProjectDAO{

	/**
	 * 
	 */
	public XmlProjectDAOImpl() {
		// TODO Auto-generated constructor stub
		
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IProjectDAO#getProject(int)
	 */
	@Override
	public Project getProject(int id) throws DAOException{
		// TODO Auto-generated method stub
		try {
			SAXBuilder builder = new SAXBuilder();
			Document projectsDocument = builder.build(Config.getConfig().getPath() + PROJECTS_XML_FILENAME);
			List<Element> projectElements = projectsDocument.getRootElement().getChildren();
			for(Element projectElement : projectElements){
				int tempId = Integer.parseInt(projectElement.getAttributeValue(KEY_ID));
				if(tempId == id){
					String name = projectElement.getChildText(KEY_NAME);
					String description = projectElement.getChildText(KEY_DESCRIPTION);
					List<Build> builds = BuildFactory.getClassFromFactory().getBuilds(id);
					User manager = UserFactory.getClassFromFactory()
							.getUser(Integer.parseInt(projectElement.getChildText(KEY_MANAGER_ID)));
					return new Project(id, name, description, builds, manager);
				}
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		return null;
	}
}
