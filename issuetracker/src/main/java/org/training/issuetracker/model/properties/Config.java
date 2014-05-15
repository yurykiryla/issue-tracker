/**
 * 
 */
package org.training.issuetracker.model.properties;

import org.training.issuetracker.model.enums.Implementations;

/**
 * @author Yury Kiryla
 *
 */
public class Config {
	private static Config config = null;
	private final String path;
	private final Implementations implementation;
	
	private Config(String path, String implementation){
		this.path = path;
		this.implementation = Implementations.valueOf(implementation.toUpperCase());
	}
	
	public static void setConfig(String path, String implementation){
		if(config == null){
			config = new Config(path, implementation);
		}else{
			throw new RuntimeException();
		}
	}
	
	public static Config GetConfig(){
		return config;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return the implementation
	 */
	public Implementations getImplementation() {
		return implementation;
	}
	
}
