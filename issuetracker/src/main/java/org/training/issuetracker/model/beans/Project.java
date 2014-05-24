package org.training.issuetracker.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Project implements Beans {
	private final int id;
	private String name;
	private String description;
	private List<Build> builds;
	private User manager;
	
	public Project(String name, String description, Build build,
			User manager) {
		super();
		id = 0;
		this.name = name;
		this.description = description;
		builds = new ArrayList<>();
		builds.add(build);
		this.manager = manager;
	}
	
	public Project(int id, String name, String description, Build build,
			User manager) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		builds = new ArrayList<>();
		builds.add(build);
		this.manager = manager;
	}
	
	public Project(int id, String name, String description, List<Build> builds,
			User manager) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.builds = builds;
		this.manager = manager;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public List<Build> getBuilds() {
		return builds;
	}

	
	public void setBuilds(List<Build> builds) {
		this.builds = builds;
	}

	
	public User getManager() {
		return manager;
	}
	
	public void setManager(User manager) {
		this.manager = manager;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}
}