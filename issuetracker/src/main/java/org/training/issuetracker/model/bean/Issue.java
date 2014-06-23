package org.training.issuetracker.model.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


@Entity
@Table(name = "issue", catalog = "issuetracker")
public class Issue implements Serializable, Comparable<Issue> {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date createDate;
	private User createdBy;
	private Date modifyDate;
	private User modifiedBy;
	private String summary;
	private String description;
	private Status status;
	private Resolution resolution;
	private Type type;
	private Priority priority;
	private Project project;
	private Build buildFound;
	private User assignee;
	private Set<Comment> comments = new HashSet<Comment>(0);
	

	public Issue() {
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

	@Column(name = "create_date", insertable = false, updatable = false, columnDefinition = "Date default CURRENT_DATE")
	@Generated(GenerationTime.INSERT)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by_id", nullable = false, updatable = false)
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "modify_date", insertable = false, updatable = false, columnDefinition = "Date default CURRENT_DATE")
	@Generated(GenerationTime.ALWAYS)
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modified_by_id", insertable = false)
	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "summary", nullable = false, length = 150)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "description", nullable = false, length = 2000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resolution_id", insertable = false)
	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", nullable = false)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "priority_id", nullable = false)
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "build_found_id", nullable = false)
	public Build getBuildFound() {
		return buildFound;
	}

	public void setBuildFound(Build buildFound) {
		this.buildFound = buildFound;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "assignee_id")
	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	@OneToMany(mappedBy = "issue", fetch = FetchType.EAGER)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", createDate=" + createDate
				+ ", createdBy=" + createdBy + ", modifyDate=" + modifyDate
				+ ", modifiedBy=" + modifiedBy + ", summary=" + summary
				+ ", description=" + description + ", status=" + status
				+ ", resolution=" + resolution + ", type=" + type
				+ ", priority=" + priority + ", project=" + project
				+ ", buildFound=" + buildFound + ", assignee=" + assignee
				+ ", comments=" + comments + "]";
	}

	@Override
	public int compareTo(Issue o) {
		return id - o.id;
	}
}
