package org.training.issuetracker.model.beans;

import java.sql.Date;

public class Issue implements Beans, Comparable<Issue> {
	private final int id;
	private Priority priority;
	private User assignee;
	private Type type;
	private Status status;
	private String summary;
	private String description;
	private Project project;
	private Build buildFound;
	private final Date createDate;
	private final User createdBy;
	private Date modifyDate;
	private User modifiedBy;
	private Resolution resolution;
	
	public Issue(Priority priority, User assignee, Type type, Status status,
			String summary, String description, Project project,
			Build buildFound, Date createDate, User createdBy) {
		super();
		id = 0;
		this.priority = priority;
		this.assignee = assignee;
		this.type = type;
		this.status = status;
		this.summary = summary;
		this.description = description;
		this.project = project;
		this.buildFound = buildFound;
		this.createDate = createDate;
		this.createdBy = createdBy;
		modifyDate = null;
		modifiedBy = null;
		resolution = null;
	}

	public Issue(int id, Priority priority, User assignee, Type type,
			Status status, String summary, String description, Project project,
			Build buildFound, Date createDate, User createdBy,
			Date modifyDate, User modifiedBy, Resolution resolution) {
		super();
		this.id = id;
		this.priority = priority;
		this.assignee = assignee;
		this.type = type;
		this.status = status;
		this.summary = summary;
		this.description = description;
		this.project = project;
		this.buildFound = buildFound;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.modifyDate = modifyDate;
		this.modifiedBy = modifiedBy;
		this.resolution = resolution;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public User getAssignee() {
		return assignee;
	}
	
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Build getBuildFound() {
		return buildFound;
	}
	
	public void setBuildFound(Build buildFound) {
		this.buildFound = buildFound;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public User getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public Resolution getResolution() {
		return resolution;
	}
	
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public User getCreatedBy() {
		return createdBy;
	}

	@Override
	public int compareTo(Issue o) {
		if(o == null){
			return 1;
		}
		return id - o.id;
	}
}