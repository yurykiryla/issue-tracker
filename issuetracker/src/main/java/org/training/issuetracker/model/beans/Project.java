package org.training.issuetracker.model.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "project", catalog = "issuetracker")
public class Project implements Beans {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private Set<Build> builds = new HashSet<Build>(0);
	private User manager;

	public Project() {
		super();
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

	@Column(name = "description", nullable = false, length = 2000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "project")
	public Set<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(Set<Build> builds) {
		this.builds = builds;
	}

	@ManyToOne
	@JoinColumn(name = "manager_id", nullable = false)
	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
