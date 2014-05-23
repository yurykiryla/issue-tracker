/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssuesDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.DAOFactory;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury
 *
 */
public class IssuesXmlDAO extends XmlDAO<Issue> implements IssuesDAO{

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
	protected Issue getOb(Element element) throws DAOException{
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
		
		Project project = DAOFactory.getProjectDAO().getOb(Integer.parseInt(element.getChildText(KEY_PROJECT_ID)));
		
		Build buildFound = DAOFactory.getBuildDAO().getOb(Integer.parseInt(element.getChildText(KEY_BUILD_FOUND_ID)));
		
		Date createDate = Date.valueOf(element.getChildText(KEY_CREATE_DATE));
		
		User createdBy = userDAO.getOb(Integer.parseInt(element.getChildText(KEY_CREATED_BY_ID)));
		
		Date modifyDate = null;
		String modifyDateString = element.getChildText(KEY_MODIFY_DATE);
		if(modifyDateString != null && !modifyDateString.isEmpty()){
			modifyDate = Date.valueOf(modifyDateString);
		}
		
		User modifiedBy = null;
		String modifiedByString = element.getChildText(KEY_MODIFIED_BY_ID);
		if(modifiedByString != null && !modifiedByString.isEmpty()){
			modifiedBy = userDAO.getOb(Integer.parseInt(element.getChildText(KEY_MODIFIED_BY_ID)));
		}
		
		Resolution resolution = null;
		String resolutionString = element.getChildText(KEY_RESOLUTION_ID);
		if(resolutionString != null && !resolutionString.isEmpty()){
			resolution = DAOFactory.getResolutionDAO().getOb(Integer.parseInt(resolutionString));
		}
		
		return new Issue(id, priority, assignee, type, status, summary, description, project, 
				buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IssueDAO#getIssues(org.training.issuetracker.model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) throws DAOException {
		// TODO Auto-generated method stub
		List<Issue> issues = getObs();
		if(user != null){
			Iterator<Issue> iterator = issues.iterator();
			while(iterator.hasNext() && n > 0){
				if(iterator.next().getAssignee().getId() != user.getId()){
					iterator.remove();
				}else{
					n--;
				}
			}
		}else if(issues.size() > n){
			Collections.sort(issues, new IssuesCreateDateComparator());
			issues = new ArrayList<>(issues.subList(0, n));
		}
		return issues;
	}

}
