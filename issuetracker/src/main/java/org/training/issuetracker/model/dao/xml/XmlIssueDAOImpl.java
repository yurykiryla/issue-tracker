/**
 * 
 */
package org.training.issuetracker.model.dao.xml;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.training.issuetracker.model.beans.Build;
import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.IIssueDAO;
import org.training.issuetracker.model.dao.IUserDAO;
import org.training.issuetracker.model.dao.exceptions.DAOException;
import org.training.issuetracker.model.dao.factories.BuildFactory;
import org.training.issuetracker.model.dao.factories.ProjectFactory;
import org.training.issuetracker.model.dao.factories.UserFactory;
import org.training.issuetracker.model.enums.Priority;
import org.training.issuetracker.model.enums.Resolution;
import org.training.issuetracker.model.enums.Status;
import org.training.issuetracker.model.enums.Type;
import org.training.issuetracker.model.properties.Config;

import static org.training.issuetracker.model.dao.xml.Constants.*;

/**
 * @author Yury Kiryla
 *
 */
public class XmlIssueDAOImpl implements IIssueDAO{

	
	/**
	 * 
	 */
	public XmlIssueDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.dao.IIssueDAO#getIssues(org.training.issuetracker.model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) throws DAOException {
		// TODO Auto-generated method stub
		List<Issue> issues = new ArrayList<>();
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(Config.getConfig().getPath() + ISSUES_XML_FILENAME);
			List<Element> elements = document.getRootElement().getChildren();		
			if(user == null){
				for(Element element : elements){
					issues.add(getIssue(element));
				}
				Collections.sort(issues, new IssuesCreateDateComparator());
				int size = issues.size();
				if(size > n){
					issues = new ArrayList<>(issues.subList(0, n));
				}
			}else{
				Iterator<Element> iterator = elements.iterator();
				int id = user.getId();
				while(iterator.hasNext() && issues.size() < n){
					Element element = iterator.next();
					Issue issue = getIssue(element);
					if(id == issue.getAssignee().getId()){
						issues.add(issue);
					}
				}
			}
		} catch (IOException | JDOMException e) {
			// TODO: handle exception
			throw new IllegalArgumentException(e);
		}
		return issues;
	}
	
	private Issue getIssue(Element element) throws DAOException{
		
		int id = Integer.parseInt(element.getAttributeValue(KEY_ID));
		
		Priority priority = Priority.valueOf(element.getChildText(KEY_PRIORITY));
		
		IUserDAO userDAO = UserFactory.getClassFromFactory();
		String assigneeIdStr = element.getChildText(KEY_ASSIGNEE_ID);
		User assignee = null;
		if(assigneeIdStr != null && !assigneeIdStr.isEmpty()){
			assignee = userDAO.getUser(Integer.parseInt(assigneeIdStr));
		}
		
		Type type = Type.valueOf(element.getChildText(KEY_TYPE));
		
		Status status = Status.valueOf(element.getChildText(KEY_STATUS));
		
		String summary = element.getChildText(KEY_SUMMARY);
		
		String description = element.getChildText(KEY_DESCRIPTION);
		
		Project project = ProjectFactory.getClassFromFactory()
				.getProject(Integer.parseInt(element.getChildText(KEY_PROJECT_ID)));
		
		Build buildFound = BuildFactory.getClassFromFactory()
				.getBuild(Integer.parseInt(element.getChildText(KEY_BUILD_FOUND_ID)));

		Date createDate = Date.valueOf(element.getChildText(KEY_CREATE_DATE));
		
		User createdBy = userDAO.getUser(Integer.parseInt(element
				.getChildText(KEY_CREATED_BY_ID)));
		
		String modifyDateStr = element.getChildText(KEY_MODIFY_DATE);
		Date modifyDate = null;
		if(modifyDateStr != null && !modifyDateStr.isEmpty()){
			modifyDate = Date.valueOf(modifyDateStr);
		}
		
		User modifiedBy = null;
		String modifiedByStr = element.getChildText(KEY_MODIFIED_BY_ID);
		if(modifiedByStr != null && !modifiedByStr.isEmpty()){
			modifiedBy = userDAO.getUser(Integer.parseInt(modifiedByStr));
		}
		
		Resolution resolution = null;
		String resolutionStr = element.getChildText(KEY_RESOLUTION);
		if(resolutionStr != null && !resolutionStr.isEmpty()){
			resolution = Resolution.valueOf(resolutionStr);
		}
		
		return new Issue(id, priority, assignee, type, status, summary, description, project, 
				buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
	}
}
