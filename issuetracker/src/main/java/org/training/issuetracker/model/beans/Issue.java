/**
 * 
 */
package org.training.issuetracker.model.beans;

import java.sql.Date;

import org.training.issuetracker.model.enums.Priority;
import org.training.issuetracker.model.enums.Resolution;
import org.training.issuetracker.model.enums.Status;
import org.training.issuetracker.model.enums.Type;

/**
 * @author Yury Kiryla
 *
 */
public class Issue {
	private final int id;
	private Priority priority;
	private User assignee;
	private Type type;
	private Status status;
	private String summary;
	private String description;
	private Project project;
	private String buildFound;
	private final Date createDate;
	private final User createdBy;
	private Date modifyDate;
	private User modifiedBy;
	private Resolution resolution;
	/**
	 * @param id
	 * @param priority
	 * @param assignee
	 * @param type
	 * @param status
	 * @param summary
	 * @param description
	 * @param project
	 * @param buildFound
	 * @param createDate
	 * @param createdBy
	 */
	public Issue(int id, Priority priority, User assignee, Type type,
			Status status, String summary, String description, Project project,
			String buildFound, Date createDate, User createdBy) {
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
	}
	
	/**
	 * @param id
	 * @param priority
	 * @param assignee
	 * @param type
	 * @param status
	 * @param summary
	 * @param description
	 * @param project
	 * @param buildFound
	 * @param createDate
	 * @param createdBy
	 * @param modifyDate
	 * @param modifiedBy
	 * @param resolution
	 */
	public Issue(int id, Priority priority, User assignee, Type type,
			Status status, String summary, String description, Project project,
			String buildFound, Date createDate, User createdBy,
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

	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	/**
	 * @return the assignee
	 */
	public User getAssignee() {
		return assignee;
	}
	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
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
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @return the buildFound
	 */
	public String getBuildFound() {
		return buildFound;
	}
	/**
	 * @param buildFound the buildFound to set
	 */
	public void setBuildFound(String buildFound) {
		this.buildFound = buildFound;
	}
	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @return the modifiedBy
	 */
	public User getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the resolution
	 */
	public Resolution getResolution() {
		return resolution;
	}
	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}
}
