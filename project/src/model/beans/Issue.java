/**
 * 
 */
package model.beans;

import model.constants.Priority;
import model.constants.Status;
import model.constants.Type;

/**
 * @author Yury Kiryla
 *
 */
public class Issue {
	private int id;
	private Priority priority;
	private User assignee;
	private Type type;
	private Status status;
	private String Summary;
	/**
	 * @param id
	 * @param priority
	 * @param assignee
	 * @param type
	 * @param status
	 * @param summary
	 */
	public Issue(int id, Priority priority, User assignee, Type type,
			Status status, String summary) {
		super();
		this.id = id;
		this.priority = priority;
		this.assignee = assignee;
		this.type = type;
		this.status = status;
		Summary = summary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	
	
}
