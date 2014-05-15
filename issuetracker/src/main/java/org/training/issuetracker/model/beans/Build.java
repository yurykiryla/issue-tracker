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
	private final int projectId;
	private final String build;
	/**
	 * @param id
	 * @param projectId
	 * @param build
	 */
	public Build(int id, int projectId, String build) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.build = build;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
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
		return "Build [id=" + id + ", projectId=" + projectId + ", build="
				+ build + "]";
	}
	
}
