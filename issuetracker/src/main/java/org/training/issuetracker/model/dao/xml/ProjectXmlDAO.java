package org.training.issuetracker.model.dao.xml;

import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

import static org.training.issuetracker.model.dao.xml.Constants.*;

public class ProjectXmlDAO extends XmlDAO<Project> {
	public ProjectXmlDAO() {
	}

	@Override
	protected String getFilename() {
		return PROJECTS_XML_FILENAME;
	}

	@Override
	protected Project getOb(Element element) throws DAOException {
		int id = getId(element);
		String name = element.getChildText(KEY_NAME);
		String description = element.getChildText(KEY_DESCRIPTION);
		List<Build> builds = DAOFactory.getBuildsDAO().getBuilds(id);
		User manager = DAOFactory.getUserDAO().getOb(Integer.parseInt(element.getChildText(KEY_MANAGER_ID)));
		return new Project(id, name, description, builds, manager);
	}
}