/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.IBuildDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.properties.Config;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury Kiryla
 *
 */
public class XmlBuildDAOImpl implements IBuildDAO {

	/**
	 * 
	 */
	public XmlBuildDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IBuildDAO#getBuild(int)
	 */
	@Override
	public Build getBuild(int id) throws DAOException{
		// TODO Auto-generated method stub
		for(Element element : getElements()){
			Build build = getBuild(element);
			if(build.getId() == id){
				return build;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IBuildDAO#getBuilds(int)
	 */
	@Override
	public List<Build> getBuilds(int projectId) throws DAOException{
		// TODO Auto-generated method stub
		List<Build> builds = new ArrayList<>();
		for(Element element : getElements()){
			if(projectId == Integer.parseInt(element.getChildText(KEY_PROJECT_ID))){
				builds.add(getBuild(element));
			}
		}
		return builds;
	}

	private Build getBuild(Element element){
		int id = Integer.parseInt(element.getAttributeValue(KEY_ID));
		String build = element.getChildText(KEY_BUILD);
		return new Build(id, build);
	}
	
	private List<Element> getElements() throws DAOException{
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(Config.getConfig().getPath() + BUILDS_XML_FILENAME);
			return document.getRootElement().getChildren();
		} catch (JDOMException | IOException e) {
			throw new DAOException(e);
		}
	}
}
