/**
 * 
 */
package org.training.issuetracker.model.beans;

/**
 * @author Yury
 *
 */
public class Type implements Beans, Comparable<Type>{
	private static int idCounter = 1;
	private final int id;
	private String name;
	
	/**
	 * @param name
	 */
	public Type(String name) {
		super();
		id = idCounter;
		idCounter++;
		this.name = name;
	}
	/**
	 * @param id
	 * @param name
	 */
	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
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
	public int compareTo(Type o) {
		// TODO Auto-generated method stub
		return id - o.id;
	}
	
}
