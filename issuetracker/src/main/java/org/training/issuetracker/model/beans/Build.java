/**
 * 
 */
package org.training.issuetracker.model.beans;

/**
 * @author Yury Kiryla
 *
 */
public class Build {
	private final int id;
	private final String build;
	/**
	 * @param id
	 * @param build
	 */
	public Build(int id, String build) {
		super();
		this.id = id;
		this.build = build;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the build
	 */
	public String getBuild() {
		return build;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Build [id=" + id + ", build=" + build + "]";
	}
			
}
