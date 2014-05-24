package org.training.issuetracker.model.beans;

import org.training.issuetracker.model.enums.Role;

public class User implements Beans, Comparable<User> {
	private final int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Role role;
	private Password password;
	
	public User(String firstName, String lastName, String emailAddress,
			Role role, Password password) {
		super();
		id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
	}

	public User(int id, String firstName, String lastName, String emailAddress,
			Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
	}
	
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

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	
	public Password getPassword() {
		return password;
	}

	
	public void setPassword(Password password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(User o) {
		if(o == null){
			return -1;
		}
		return id - o.id;
	}
}