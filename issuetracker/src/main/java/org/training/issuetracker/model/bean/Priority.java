package org.training.issuetracker.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priority", catalog = "issuetracker")
public class Priority implements Bean, Comparable<Priority> {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public Priority() {
		super();
	}

	public Priority(int id) {
		super();
		this.id = id;
	}

	public Priority(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
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
	public int compareTo(Priority o) {
		return id - o.id;
	}
}