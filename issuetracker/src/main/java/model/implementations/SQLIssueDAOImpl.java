/**
 * 
 */
package model.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.beans.Issue;
import model.beans.User;
import model.db.DBConnection;
import model.interfaces.IIssueDAO;

/**
 * @author Yury
 *
 */
public class SQLIssueDAOImpl implements IIssueDAO {

	/* (non-Javadoc)
	 * @see model.interfaces.IIssueDAO#getIssues(model.beans.User, int)
	 */
	@Override
	public List<Issue> getIssues(User user, int n) {
		// TODO Auto-generated method stub
		List<Issue> issues = new ArrayList<>();
		try(DBConnection dbConnection = new DBConnection()){
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet resultSet;
			if(user == null){
				resultSet = statement.executeQuery("");
			}else{
				resultSet = statement.executeQuery("");
			}
			while(resultSet.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		return issues;
	}

}
