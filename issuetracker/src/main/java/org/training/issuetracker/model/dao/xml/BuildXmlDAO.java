/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.dao.BuildsDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury Kiryla
 *
 */
public class BuildXmlDAO extends XmlDAO<Build> implements BuildsDAO{

	/**
	 * 
	 */
	public BuildXmlDAO() {
		// TODO Auto-generated constructor stub
	}

	
	
	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getFilename()
	 */
	@Override
	protected String getFilename() {
		// TODO Auto-generated method stub
		return BUILDS_XML_FILENAME;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getOb(org.jdom2.Element)
	 */
	@Override
	protected Build getOb(Element element) throws DAOException {
		// TODO Auto-generated method stub
		String name = element.getChildText(KEY_NAME); 
		return new Build(getId(element), name);
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.BuildsDAO#getBuilds(org.training.issuetracker.model.beans.Project)
	 */
	@Override
	public List<Build> getBuilds(int projectId) throws DAOException{
		// TODO Auto-generated method stub
		List<Build> builds = new ArrayList<>();
		for(Element element : getElements()){
			if(projectId == Integer.parseInt(element.getChildText(KEY_PROJECT_ID))){
				builds.add(getOb(element));
			}
		}
		return builds;
	}



	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.BuildsDAO#addBuild(org.training.issuetracker.model.beans.Build, int)
	 */
	@Override
	public void addBuild(Build build, int projectId) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
