/**
 * 
 */
package org.training.issuetracker.model.beans;

/**
 * @author Yury Kiryla
 *
 */
public class Build implements Beans {
	private final int id;
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public Build(int id, String name) {
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
	
	
}
