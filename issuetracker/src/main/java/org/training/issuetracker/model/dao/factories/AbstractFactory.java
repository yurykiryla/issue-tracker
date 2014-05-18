/**
 * 
 */
package org.training.issuetracker.model.dao.factories;

import org.training.issuetracker.model.beans.Issue;
import org.training.issuetracker.model.beans.Priority;
import org.training.issuetracker.model.beans.Project;
import org.training.issuetracker.model.beans.Resolution;
import org.training.issuetracker.model.beans.Status;
import org.training.issuetracker.model.beans.Type;
import org.training.issuetracker.model.beans.User;
import org.training.issuetracker.model.dao.DAO;
import org.training.issuetracker.model.dao.IssuesDAO;

/**
 * @author Yury
 *
 */
public interface AbstractFactory {
	public DAO<Issue> getIssueDAO();
	public DAO<Priority> getPriorityDAO();
	public DAO<Project> getProjectDAO();
	public DAO<Resolution> getResolutionDAO();
	public DAO<Status> getStatusDAO();
	public DAO<Type> getTypeDAO();
	public DAO<User> getUserDAO();
	public IssuesDAO getIssuesDAO();
}
