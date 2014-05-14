package org.training.issuetracker.controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
    	String path = arg0.getServletContext().getRealPath("/") + "WEB-INF\\classes\\";
    	Config.setConfig(path);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
