/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
		for(Build build : getBuilds()){
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
		List<Build> builds = getBuilds();
		Iterator<Build> iterator = builds.iterator();
		while(iterator.hasNext()){
			Build build = iterator.next();
			if(build.getProjectId() != projectId){
				iterator.remove();
			}
		}
		return builds;
	}
	
	private List<Build> getBuilds() throws DAOException{
		List<Build> builds = new ArrayList<>();
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(Config.GetConfig().getPath() + BUILDS_XML_FILENAME);
			List<Element> elements = document.getRootElement().getChildren();
			for(Element element : elements){
				int id = Integer.parseInt(element.getAttributeValue(KEY_ID));
				int projectId = Integer.parseInt(element.getChildText(KEY_PROJECT_ID));
				String build = element.getChildText(KEY_BUILD_ID);
				builds.add(new Build(id, projectId, build));
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		return builds;
	}
}
