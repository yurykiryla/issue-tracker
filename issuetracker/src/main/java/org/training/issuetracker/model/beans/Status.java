/**
 * 
 */
package org.training.issuetracker.model.beans;

/**
 * @author Yury
 *
 */
public class Status implements Beans, Comparable<Status> {
	private static int idCounter = 1;
	private final int id;
	private String name;
	

	/**
	 * @param name
	 */
	public Status(String name) {
		super();
		id = idCounter;
		idCounter++;
		this.name = name;
	}


	/**
	 * @param id
	 * @param name
	 */
	public Status(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see org.training.issuetracker.model.beans.Beans#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Status o) {
		// TODO Auto-generated method stub
		return id - o.id;
	}

}
