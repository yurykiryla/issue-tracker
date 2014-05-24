package org.training.issuetracker.controllers.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.training.issuetracker.controllers.Constants;
import org.training.issuetracker.model.properties.Config;

/**
 * Application Lifecycle Listener implementation class PropertiesListener
 *
 */
public class PropertiesListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PropertiesListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	String path = arg0.getServletContext().getRealPath(Constants.ROOT_PATH) 
    			+ Constants.RESOURCES_PATH;
    	String impl = arg0.getServletContext().getInitParameter(Constants.KEY_IMPLEMENTATION);
    	String contextPath = arg0.getServletContext().getContextPath();
    	int n = Integer.parseInt(arg0.getServletContext().getInitParameter(Constants.KEY_N));
    	Config.setConfig(path, impl, contextPath, n);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
