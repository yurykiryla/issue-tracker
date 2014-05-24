package org.training.issuetracker.model.beans;

public class Priority implements Beans, Comparable<Priority> {
	private final int id;
	private String name;
	
	public Priority(String name) {
		super();
		id = 0;
		this.name = name;
	}

	public Priority(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Priority o) {
		if(o == null){
			return 1;
		}
		return id - o.id;
	}
}