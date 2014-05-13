package org.training.issuetracker.model.beans;

public class Project {
	private final int id;
	private String name;
	private String description;
	private String build;
	private User manager;
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param build
	 * @param manager
	 */
	public Project(int id, String name, String description, String build,
			User manager) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.build = build;
		this.manager = manager;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the build
	 */
	public String getBuild() {
		return build;
	}
	/**
	 * @param build the build to set
	 */
	public void setBuild(String build) {
		this.build = build;
	}
	/**
	 * @return the manager
	 */
	public User getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
