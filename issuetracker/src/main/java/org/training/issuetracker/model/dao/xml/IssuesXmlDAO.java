/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.factories.DAOFactory;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury
 *
 */
public class IssuesXmlDAO extends XmlDAO<Issue>{

	/**
	 * 
	 */
	public IssuesXmlDAO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getFilename()
	 */
	@Override
	protected String getFilename() {
		// TODO Auto-generated method stub
		return ISSUES_XML_FILENAME;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.xml.XmlDAO#getOb(org.jdom2.Element)
	 */
	@Override
	protected Issue getOb(Element element) {
		// TODO Auto-generated method stub
		int id = getId(element);
		
		Priority priority = DAOFactory.getPriorityDAO()
				.getOb(Integer.parseInt(element.getChildText(KEY_PRIORITY_ID)));
		
		DAO<User> userDAO = DAOFactory.getUserDAO();
		User assignee = null;
		String assigneeIdString = element.getChildText(KEY_ASSIGNEE_ID);
		if(assigneeIdString != null && !assigneeIdString.isEmpty()){
			assignee = userDAO.getOb(Integer.parseInt(assigneeIdString));
		}
		
		Type type = DAOFactory.getTypeDAO().getOb(Integer.parseInt(element.getChildText(KEY_TYPE_ID)));
		
		Status status = DAOFactory.getStatusDAO().getOb(Integer.parseInt(element.getChildText(KEY_STATUS_ID)));
		
		String summary = element.getChildText(KEY_SUMMARY);
		
		String description = element.getChildText(KEY_DESCRIPTION);
		
				
		
		return new Issue(id, priority, assignee, type, status, summary, description, project, 
				buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
	}

}
