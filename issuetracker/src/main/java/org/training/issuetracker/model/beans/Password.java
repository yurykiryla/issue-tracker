/**
 * 
 */
package org.training.issuetracker.model.beans;

/**
 * @author Yury
 *
 */
public class Password {
	private String password;
	/**
	 * 
	 */
	public Password() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param password
	 */
	public Password(String password) {
		super();
		this.password = password;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void encryptPassword(String password){
		this.password = password;
	}
	
	public boolean checkPassword(String password){
		return decryptPassword().equals(password);
	}
	
	private String decryptPassword(){
		return password;
	}
}
