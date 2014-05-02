/**
 * 
 */
package model.implementations;

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

import model.beans.Issue;
import model.beans.Project;
import model.beans.User;
import model.constants.Constants;
import model.constants.Priority;
import model.constants.Resolution;
import model.constants.Status;
import model.constants.Type;
import model.factories.UserFactory;
import model.interfaces.IIssueDAO;
import model.interfaces.IUserDAO;

/**
 * @author Yury Kiryla
 *
 */
public class XmlIssueDAOImpl implements IIssueDAO{

	/* (non-Javadoc)
	 * @see model.interfaces.IIssueDAO#getIssues(model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) {
		// TODO Auto-generated method stub
		List<Issue> issues = new ArrayList<>();
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(this.getClass().getClassLoader()
					.getResourceAsStream(Constants.ISSUES_XML_FILENAME));
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
		} catch (JDOMException | IOException e) {
			// TODO: handle exception
			throw new IllegalArgumentException(e);
		}
		return issues;
	}
	
	private Issue getIssue(Element element){
		int id = Integer.parseInt(element.getAttributeValue(Constants.KEY_ID));
		Priority priority = Priority.valueOf(element.getChildText(Constants.KEY_PRIORITY));
		IUserDAO userDAO = UserFactory.getClassFromFactory();
		User assignee = userDAO.getUser(Integer.parseInt(element
				.getChildText(Constants.KEY_ASSIGNEE)));
		Type type = Type.valueOf(element.getChildText(Constants.KEY_TYPE));
		Status status = Status.valueOf(element.getChildText(Constants.KEY_STATUS));
		String summary = element.getChildText(Constants.KEY_SUMMARY);
		String description = element.getChildText(Constants.KEY_DESCRIPTION);
		//correct project value after include projectsDao
		Project project = new Project(Integer.parseInt(element.getChildText(Constants.KEY_PROJECT)),
				null, null, null, null);
		String buildFound = element.getChildText(Constants.KEY_BUILD_FOUND);
		Date createDate = Date.valueOf(element.getChildText(Constants.KEY_CREATE_DATE));
		User createdBy = userDAO.getUser(Integer.parseInt(element
				.getChildText(Constants.KEY_CREATED_BY)));
		String modifyDateStr = element.getChildText(Constants.KEY_MODIFY_DATE);
		Date modifyDate = null;
		if(!modifyDateStr.isEmpty()){
			modifyDate = Date.valueOf(modifyDateStr);
		}
		User modifiedBy = null;
		String modifiedByStr = element.getChildText(Constants.KEY_MODIFIED_BY);
		if(!modifiedByStr.isEmpty()){
			modifiedBy = userDAO.getUser(Integer.parseInt(modifiedByStr));
		}
		Resolution resolution = null;
		String resolutionStr = element.getChildText(Constants.KEY_RESOLUTION);
		if(!resolutionStr.isEmpty()){
			resolution = Resolution.valueOf(resolutionStr);
		}
		return new Issue(id, priority, assignee, type, status, summary, description, project, 
				buildFound, createDate, createdBy, modifyDate, modifiedBy, resolution);
	}
}
