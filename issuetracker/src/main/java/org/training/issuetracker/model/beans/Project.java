package org.training.issuetracker.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Project implements Beans{
	private final int id;
	private String name;
	private String description;
	private List<String> builds;
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
		builds = new ArrayList<>();
		builds.add(build);
		this.manager = manager;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param builds
	 * @param manager
	 */
	public Project(int id, String name, String description, List<String> builds,
			User manager) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.builds = builds;
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
	 * @return the builds
	 */
	public List<String> getBuilds() {
		return builds;
	}

	/**
	 * @param builds the builds to set
	 */
	public void setBuilds(List<String> builds) {
		this.builds = builds;
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
