package org.training.issuetracker.model.beans;

public class Password {
	private String encryptedPassword;
	
	public Password() {
		super();
	}
	
	public Password(String password){
		encryptedPassword = encryptPassword(password);
	}
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

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