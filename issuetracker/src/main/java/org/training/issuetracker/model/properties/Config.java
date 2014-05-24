package org.training.issuetracker.model.properties;

import org.training.issuetracker.model.enums.Implementations;

public class Config {
	private static Config config = null;
	private final String path;
	private final Implementations implementation;
	private final String contextPath;
	private final int n;
	
	private Config(String path, String implementation, String contextPath, int n) {
		this.path = path;
		this.implementation = Implementations.valueOf(implementation.toUpperCase());
		this.contextPath = contextPath;
		this.n = n;
	}
	
	public static void setConfig(String path, String implementation, String contextPath, int n) {
		if (config == null) {
			config = new Config(path, implementation, contextPath, n);
		}
	}
	
	public static Config getConfig() {
		return config;
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