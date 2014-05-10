package model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1) + ";" + resultSet.getString(2));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
