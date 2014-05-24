package org.training.issuetracker.model.beans;

public class Status implements Beans, Comparable<Status> {
	private final int id;
	private String name;
	
	public Status(String name) {
		super();
		id = 0;
		this.name = name;
	}

	public Status(int id, String name) {
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

	@Override
	public int compareTo(Status o) {
		if(o == null){
			return 1;
		}
		return id - o.id;
	}
}