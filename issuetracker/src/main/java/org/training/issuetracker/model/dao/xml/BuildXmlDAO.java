package org.training.issuetracker.model.dao.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.bean.Build;
import org.training.issuetracker.model.bean.Project;
import org.training.issuetracker.model.dao.BuildDAO;
import org.training.issuetracker.model.dao.exception.DAOException;

import static org.training.issuetracker.model.dao.xml.Constants.*;

public class BuildXmlDAO extends XmlDAO<Build> implements BuildDAO{

	public BuildXmlDAO() {
	}
	
	@Override
	protected String getFilename() {
		return BUILDS_XML_FILENAME;
	}

	@Override
	protected Build getOb(Element element) throws DAOException {
		return new Build();
	}

	@Override
	public List<Build> getBuilds(Project project) throws DAOException {
		List<Build> builds = new ArrayList<Build>();
		for (Element element : getElements()) {
			if (project.getId() == Integer.parseInt(element.getChildText(KEY_PROJECT_ID))) {
				builds.add(getOb(element));
			}
		}
		return builds;
	}

}
