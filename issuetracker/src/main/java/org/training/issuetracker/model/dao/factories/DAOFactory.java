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
import org.training.issuetracker.model.dao.jdbc.SQLDAOFactory;
import org.training.issuetracker.model.dao.xml.XmlDAOFactory;
import org.training.issuetracker.model.properties.Config;


/**
 * @author Yury
 *
 */
public class DAOFactory {
	private static AbstractFactory factory= null;
	
	private static AbstractFactory getFactory(){
		if(factory == null){
			switch (Config.getConfig().getImplementation()){
				case XML:
					factory = new XmlDAOFactory();
					break;
				case JDBC:
					factory = new SQLDAOFactory();
					break;
			}
		}
		return factory;
	}
	
	public static DAO<Issue> getIssueDAO(){
		return getFactory().getIssueDAO();
	}
	
	public static DAO<Priority> getPriorityDAO(){
		return getFactory().getPriorityDAO();
	}
	
	public static DAO<Project> getProjectDAO(){
		return getFactory().getProjectDAO();
	}
	
	public static DAO<Resolution> getResolutionDAO(){
		return getFactory().getResolutionDAO();
	}
	
	public static DAO<Status> getStatusDAO(){
		return getFactory().getStatusDAO();
	}
	
	public static DAO<Type> getTypeDAO(){
		return getFactory().getTypeDAO();
	}
	
	public static DAO<User> getUserDAO(){
		return getFactory().getUserDAO();
	}
	
	public static IssuesDAO getIssuesDAO(){
		return getFactory().getIssuesDAO();
	}
}
