/**
 * 
 */
package org.training.issuetracker.model.dao.jdbc;

/**
 * @author Yury
 *
 */
public class SQLRequests {
	public static final String CREATE_ISSUES_TABLE = 
			"CREATE TABLE issues ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
				+ "summary LONG VARCHAR NOT NULL,"
				+ "description LONG VARCHAR NOT NULL,"
				+ "status LONG VARCHAR NOT NULL,"
				+ "type LONG VARCHAR NOT NULL,"
				+ "priority LONG VARCHAR NOT NULL,"
				+ "project_id INT NOT NULL,"
				+ "build_found_id INT NOT NULL,"
				+ "assignee_id INT DEFAULT NULL,"
				+ "create_date DATE NOT NULL,"
				+ "created_by_id INT NOT NULL,"
				+ "modify_date DATE DEFAULT NULL,"
				+ "modified_by_id INT DEFAULT NULL,"
				+ "resolution LONG VARCHAR DEFAULT NULL"
			+ ")";
	
	public static final String CREATE_DEFAULT_ADMINISTRATOR = 
			"INSERT INTO users (first_name, last_name, email_address, role, password)"
				+ "VALUES ('admin', 'admin', 'admin', 'ADMINISTRATOR', 'admin')";
				
	public static final String CREATE_DEFAULT_USER = 
			"INSERT INTO users (first_name, last_name, email_address, role, password)"
				+ "VALUES ('user', 'user', 'user', 'USER', 'user')";
	
	public static final String CREATE_USERS_TABLE = 
			"CREATE TABLE users ("
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "first_name LONG VARCHAR NOT NULL, "
				+ "last_name LONG VARCHAR NOT NULL, "
				+ "email_address LONG VARCHAR NOT NULL, "
				+ "role LONG VARCHAR NOT NULL, "
				+ "password LONG VARCHAR NOT NULL"
			+ ")";
	
	public static final String SELECT_ASSEGNEE_ISSUES = 
			"SELECT * FROM issues WHERE assignee_id=";
	
	public static final String SELECT_DEFAULT_ISSUES = 
			"SELECT * FROM issues ORDER BY create_date DESC";
	
	public static final String SELECT_USER_BY_ID = 
			"SELECT * FROM users WHERE id=";
	
	public static final String SELECT_USER_BY_EMAIL_PASSWORD_1 = 
			"SELECT * FROM users WHERE (CAST(email_address AS VARCHAR(32672))='";
	
	public static final String SELECT_USER_BY_EMAIL_PASSWORD_2 = 
			"') AND (CAST(password AS VARCHAR(32672))='";
	
	public static final String SELECT_USER_BY_EMAIL_PASSWORD_3 = 
			"')";
}
