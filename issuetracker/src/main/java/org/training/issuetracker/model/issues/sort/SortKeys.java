package org.training.issuetracker.model.issues.sort;

public enum SortKeys {
	ID("id"), 
	PRIORITY("priority_id"), 
	ASSIGNEE("assignee_id"), 
	TYPE("type_id"), 
	STATUS("status_id"), 
	SUMMARY("summary"),
	CREATE_DATE("create_date");
	private String value;
	
	private SortKeys(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}	
}