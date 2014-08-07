package org.training.issuetracker.controller.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.training.issuetracker.controller.Configuration;
import org.training.issuetracker.controller.Constants;
import org.training.issuetracker.model.dao.hibernate.HibernateUtil;
import org.training.issuetracker.model.enums.Implementations;

/**
 * Application Lifecycle Listener implementation class IssueTrackerContextListener
 *
 */
public class IssueTrackerContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public IssueTrackerContextListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	String path = arg0.getServletContext().getRealPath(Constants.ROOT_PATH) 
    			+ Constants.RESOURCES_PATH;
    	Implementations implementation = Implementations.HIBERNATE;
    	String contextPath = arg0.getServletContext().getContextPath();
    	int n = 10;
    	Configuration.set(path, implementation, contextPath, n);
        HibernateUtil.buildSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	HibernateUtil.close();
    }
	
}
