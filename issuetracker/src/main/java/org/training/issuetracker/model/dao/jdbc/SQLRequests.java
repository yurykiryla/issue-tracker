package org.training.issuetracker.model.dao.jdbc;

public class SQLRequests {
	public static final String CREATE_BUILDS_TABLE = 
			"CREATE TABLE builds ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
				+ "name LONG VARCHAR NOT NULL,"
				+ "project_id INT NOT NULL"
			+ ")";
	
	public static final String CREATE_ISSUES_TABLE = 
			"CREATE TABLE issues ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
				+ "priority_id INT NOT NULL,"
				+ "assignee_id INT,"
				+ "type_id INT NOT NULL,"
				+ "status_id INT NOT NULL,"
				+ "summary LONG VARCHAR NOT NULL,"
				+ "description LONG VARCHAR NOT NULL,"
				+ "project_id INT NOT NULL,"
				+ "build_found_id INT NOT NULL,"
				+ "create_date DATE NOT NULL,"
				+ "created_by_id INT NOT NULL,"
				+ "modify_date DATE,"
				+ "modified_by_id INT,"
				+ "resolution_id INT"
			+ ")";
	
	public static final String CREATE_DEFAULT_ADMINISTRATOR = 
			"INSERT INTO users (first_name, last_name, email_address, role, password)"
				+ "VALUES ('admin', 'admin', 'admin', 'ADMINISTRATOR', 'admin')";
	
	public static final String CREATE_DEFAULT_BUILD = 
			"INSERT INTO builds (name, project_id)"
				+ "VALUES ('1.0', 1)";
	
	public static final String CREATE_DEFAULT_PROJECT = 
			"INSERT INTO projects (name, description, manager_id)"
				+ "VALUES ('proj1', 'project 1', 1)";
				
	public static final String CREATE_DEFAULT_USER = 
			"INSERT INTO users (first_name, last_name, email_address, role, password)"
				+ "VALUES ('user', 'user', 'user', 'USER', 'user')";
	
	public static final String CREATE_PRIORITIES_TABLE = 
			"CREATE TABLE priorities ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "name LONG VARCHAR NOT NULL"
			+ ")";
	
	public static final String CREATE_PRIORITY_CRITICAL = 
			"INSERT INTO priorities (name) VALUES ('Critical')";
	
	public static final String CREATE_PRIORITY_IMPORTANT = 
			"INSERT INTO priorities (name) VALUES ('Important')";
	
	public static final String CREATE_PRIORITY_MAJOR = 
			"INSERT INTO priorities (name) VALUES ('Major')";
	
	public static final String CREATE_PRIORITY_MINOR = 
			"INSERT INTO priorities (name) VALUES ('Minor')";
	
	public static final String CREATE_PROJECTS_TABLE = 
			"CREATE TABLE projects ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
				+ "name LONG VARCHAR NOT NULL,"
				+ "description LONG VARCHAR NOT NULL,"
				+ "manager_id INT NOT NULL"
			+ ")";

	public static final String CREATE_RESOLUTION_INVALID = 
			"INSERT INTO resolutions (name) VALUES ('Invalid')";
	
	public static final String CREATE_RESOLUTION_FIXED = 
			"INSERT INTO resolutions (name) VALUES ('Fixed')";
	
	public static final String CREATE_RESOLUTION_WONTFIX = 
			"INSERT INTO resolutions (name) VALUES ('Wontfix')";
	
	public static final String CREATE_RESOLUTION_WORKSFORME = 
			"INSERT INTO resolutions (name) VALUES ('Worksforme')";
	
	public static final String CREATE_RESOLUTIONS_TABLE = 
			"CREATE TABLE resolutions ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "name LONG VARCHAR NOT NULL"
			+ ")";
	
	public static final String CREATE_STATUS_ASSIGNED = 
			"INSERT INTO statuses (name) VALUES ('Assigned')";
	
	public static final String CREATE_STATUS_CLOSED = 
			"INSERT INTO statuses (name) VALUES ('Closed')";
	
	public static final String CREATE_STATUS_IN_PROGRESS = 
			"INSERT INTO statuses (name) VALUES ('In Progress')";
	
	public static final String CREATE_STATUS_NEW = 
			"INSERT INTO statuses (name) VALUES ('New')";
	
	public static final String CREATE_STATUS_REOPENED = 
			"INSERT INTO statuses (name) VALUES ('Reopened')";
	
	public static final String CREATE_STATUS_RESOLVED = 
			"INSERT INTO statuses (name) VALUES ('Resolved')";
	
	public static final String CREATE_STATUSES_TABLE = 
			"CREATE TABLE statuses ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "name LONG VARCHAR NOT NULL"
			+ ")";
	
	public static final String CREATE_TYPE_BUG = 
			"INSERT INTO types (name) VALUES ('Bug')";
	
	public static final String CREATE_TYPE_COSMETIC = 
			"INSERT INTO types (name) VALUES ('Cosmetic')";
	
	public static final String CREATE_TYPE_FEATURE = 
			"INSERT INTO types (name) VALUES ('Feature')";
	
	public static final String CREATE_TYPE_PERFOMANCE = 
			"INSERT INTO types (name) VALUES ('Perfomance')";
	
	public static final String CREATE_TYPES_TABLE = 
			"CREATE TABLE types ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "name LONG VARCHAR NOT NULL"
			+ ")";
	
	public static final String CREATE_USERS_TABLE = 
			"CREATE TABLE users ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "first_name LONG VARCHAR NOT NULL, "
				+ "last_name LONG VARCHAR NOT NULL, "
				+ "email_address LONG VARCHAR NOT NULL, "
				+ "role LONG VARCHAR NOT NULL, "
				+ "password LONG VARCHAR NOT NULL"
			+ ")";
	
	public static final String INSERT_BUILD = 
			"INSERT INTO builds (name, project_id) VALUES (?,?)";
	
	public static final String INSERT_ISSUE = 
			"INSERT INTO issues "
				+ "(priority_id, assignee_id, type_id, status_id, summary, description, project_id, "
				+ "build_found_id, create_date, created_by_id, modify_date, modified_by_id, resolution_id) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_PRIORITY = 
			"INSERT INTO priorities (name) VALUES (?)";
	
	public static final String INSERT_PROJECT = 
			"INSERT INTO projects (name, description, manager_id) VALUES (?,?,?)";
	
	public static final String INSERT_RESOLUTION = 
			"INSERT INTO resolutions (name) VALUES (?)";
	
	public static final String INSERT_TYPE = 
			"INSERT INTO types (name) VALUES (?)";
	
	public static final String INSERT_USER = 
			"INSERT INTO users (first_name, last_name, email_address, role, password) "
				+ "VALUES (?,?,?,?,?)";
	
	public static final String SELECT_BUILD_BY_ID = 
			"SELECT * FROM builds WHERE id=?";
	
	public static final String SELECT_BUILDS = 
			"SELECT * FROM builds";
	
	public static final String SELECT_BUILDS_BY_PROJECT_ID = 
			"SELECT * FROM builds WHERE project_id=?";
	
	public static final String SELECT_ISSUE_BY_ID = 
			"SELECT * FROM issues WHERE id=?";
	
	public static final String SELECT_ISSUES = 
			"SELECT * FROM issues";
	
	public static final String SELECT_SORTED_ISSUES = 
			"SELECT * FROM issues ORDER BY ";
	
	public static final String SELECT_PRIORITIES = 
			"SELECT * FROM priorities";
	
	public static final String SELECT_PRIORITY_BY_ID = 
			"SELECT * FROM priorities WHERE id=?";
	
	public static final String SELECT_PROJECT_BY_ID = 
			"SELECT * FROM projects WHERE id=?";
	
	public static final String SELECT_PROJECTS = 
			"SELECT * FROM projects";
	
	public static final String SELECT_RESOLUTION_BY_ID = 
			"SELECT * FROM resolutions WHERE id=?";
	
	public static final String SELECT_RESOLUTIONS = 
			"SELECT * FROM resolutions";
	
	public static final String SELECT_STATUS_BY_ID = 
			"SELECT * FROM statuses WHERE id=?";
	
	public static final String SELECT_STATUSES = 
			"SELECT * FROM statuses";
	
	public static final String SELECT_TYPE_BY_ID = 
			"SELECT * FROM types WHERE id=?";
	
	public static final String SELECT_TYPES = 
			"SELECT * FROM types";
	
	public static final String SELECT_USER_BY_ID = 
			"SELECT * FROM users WHERE id=?";
	
	public static final String SELECT_USER_BY_EMAIL = 
			"SELECT * FROM users WHERE CAST(email_address AS VARCHAR(32672))=?";
	
	public static final String SELECT_USERS = 
			"SELECT * FROM users";
	
	public static final String UPDATE_ISSUE = 
			"UPDATE issues SET "
				+ "priority_id=?, assignee_id=?, type_id=?, status_id=?, summary=?, description=?, "
				+ "project_id=?, build_found_id=?, create_date=?, created_by_id=?, modify_date=?, "
				+ "modified_by_id=?, resolution_id=? "
				+ "WHERE id=?";
	
	public static final String UPDATE_PRIORITY = 
			"UPDATE priorities SET name=? WHERE id=?";
	
	public static final String UPDATE_PROJECT = 
			"UPDATE projects SET name=?, description=?, manager_id=? WHERE id=?";
	
	public static final String UPDATE_RESOLUTION = 
			"UPDATE resolutions SET name=? WHERE id=?";
	
	public static final String UPDATE_STATUS = 
			"UPDATE statuses SET name=? WHERE id=?";
	
	public static final String UPDATE_TYPE = 
			"UPDATE types SET name=? WHERE id=?";
	
	public static final String UPDATE_USER = 
			"UPDATE users SET first_name=?, last_name=?, email_address=?, role=?, password=? WHERE id=?";
}