/**
 * 
 */
package org.training.issuetracker.model.beans;

/**
 * @author Yury
 *
 */
public class Password {
	private String encryptedPassword;
	/**
	 * 
	 */
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Password(String password){
		encryptedPassword = encryptPassword(password);
	}
	/**
	 * @return the encryptedPassword
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	/**
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public boolean checkPassword(String password){
		return this.encryptedPassword.equals(encryptPassword(password));
	}
	private String encryptPassword(String password){
		return password;
	}
}
