/**
 * 
 */
package org.training.issuetracker.model.enums;

/**
 * @author Yury
 *
 */
public enum Resolution {
	FIXED("Fixed"),
	INVALID("Invalid"), 
	WONTFIX("Wontfix"), 
	WORKSFORME("Worksforme");
	

	private String name;
	
	private Resolution(String name){
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
