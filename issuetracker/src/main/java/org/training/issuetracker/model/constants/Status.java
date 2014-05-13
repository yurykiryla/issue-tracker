/**
 * 
 */
package org.training.issuetracker.model.constants;

/**
 * @author Yury Kiryla
 *
 */
public enum Status {
	NEW("New"), 
	ASSIGNED("Assigned"), 
	IN_PROGRESS("In Progress"), 
	RESOLVED("Resolved"), 
	CLOSED("Closed"), 
	REOPENED("Reopened");
	
	private String name;
	
	private Status(String name){
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
