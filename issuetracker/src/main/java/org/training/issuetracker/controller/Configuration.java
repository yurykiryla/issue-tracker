package org.training.issuetracker.controller;

import org.training.issuetracker.model.enums.Implementations;


public class Configuration {
	private static Configuration configuration = null;
	private final String path;
	private final Implementations implementation;
	private final String contextPath;
	private final int n;
	
	private Configuration(String path, Implementations implementation,
			String contextPath, int n) {
		super();
		this.path = path;
		this.implementation = implementation;
		this.contextPath = contextPath;
		this.n = n;
	}
	
	public static void set(String path, Implementations implementation, String contextPath, int n) {
		if (configuration == null) {
			configuration = new Configuration(path, implementation, contextPath, n);
		}
	}

	public static Configuration get() {
		return configuration;
	}
	
	public String getPath() {
		return path;
	}

	public Implementations getImplementation() {
		return implementation;
	}

	public String getContextPath() {
		return contextPath;
	}

	public int getN() {
		return n;
	}
	
	
}
