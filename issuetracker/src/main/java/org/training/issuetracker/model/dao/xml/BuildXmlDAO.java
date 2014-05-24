package org.training.issuetracker.model.dao.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.BuildsDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

import static org.training.issuetracker.model.dao.xml.Constants.*;

public class BuildXmlDAO extends XmlDAO<Build> implements BuildsDAO{

	public BuildXmlDAO() {
	}
	
	@Override
	protected String getFilename() {
		return BUILDS_XML_FILENAME;
	}

	@Override
	protected Build getOb(Element element) throws DAOException {
		String name = element.getChildText(KEY_NAME); 
		return new Build(getId(element), name);
	}

	@Override
	public List<Build> getBuilds(int projectId) throws DAOException {
		List<Build> builds = new ArrayList<>();
		for (Element element : getElements()) {
			if (projectId == Integer.parseInt(element.getChildText(KEY_PROJECT_ID))) {
				builds.add(getOb(element));
			}
		}
		return builds;
	}

	@Override
	public void addBuild(Build build, int projectId) throws DAOException {
		throw new DAOException(MESSAGE_UNSUPPORTED_OPERATION);
	}
}
