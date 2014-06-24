package org.training.issuetracker.model.dao.xml;

import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.bean.User;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.dao.factory.DAOFactory;

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
		List<Build> builds = DAOFactory.getBuildDAO().getBuilds(new Project());
		User manager = DAOFactory.getUserDAO().getOb(Integer.parseInt(element.getChildText(KEY_MANAGER_ID)));
		return new Project();
	}
}