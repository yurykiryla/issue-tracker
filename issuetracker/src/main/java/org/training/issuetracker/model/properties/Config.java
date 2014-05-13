/**
 * 
 */
package org.training.issuetracker.model.properties;

/**
 * @author Yury Kiryla
 *
 */
public class Config {
	private static Config config = null;
	private final String path;
	
	private Config(String path){
		this.path = path;
	}
	
	public static void setConfig(String path){
		if(config == null){
			config = new Config(path);
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
}
