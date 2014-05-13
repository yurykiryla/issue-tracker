/**
 * 
 */
package org.training.issuetracker.model.enums;

/**
 * @author Yury Kiryla
 *
 */
public enum Priority {
	CRITICAL ("Critical"), 
	MAJOR ("Major"), 
	IMPORTANT ("Important"), 
	MINOR ("Minor");
	
	private String name;
	
	private Priority(String name){
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
