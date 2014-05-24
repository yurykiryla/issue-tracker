package org.training.issuetracker.model.beans;

public class Build implements Beans {
	private final int id;
	private String name;

	public Build(String name) {
		super();
		id = 0;
		this.name = name;
	}

	public Build(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}