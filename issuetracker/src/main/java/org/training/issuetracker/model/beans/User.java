/**
 * 
 */
package org.training.issuetracker.model.beans;

import org.training.issuetracker.model.enums.Role;



/**
 * @author Yury Kiryla
 *
 */
public class User implements Beans{
	private static int idCounter = 1;
	private final int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Role role;
	private Password password;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param role
	 * @param password
	 */
	public User(String firstName, String lastName, String emailAddress,
			Role role, Password password) {
		super();
		id = idCounter;
		idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param role
	 */
	public User(int id, String firstName, String lastName, String emailAddress,
			Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
	}
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param role
	 * @param password
	 */
	public User(int id, String firstName, String lastName, String emailAddress,
			Role role, Password password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public Password getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(Password password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
