package org.training.issuetracker.model.beans;

public class Type implements Beans, Comparable<Type>{
	private final int id;
	private String name;
	
	public Type(String name) {
		super();
		id = 0;
		this.name = name;
	}

	public Type(int id, String name) {
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
	public int compareTo(Type o) {
		if(o == null){
			return 1;
		}
		return id - o.id;
	}
}