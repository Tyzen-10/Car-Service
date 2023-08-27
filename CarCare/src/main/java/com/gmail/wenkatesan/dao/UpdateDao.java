package com.gmail.wenkatesan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class UpdateDao {
	//String sql = "select * from users where uname=? and pass=?";
	String assignMechanicSql = "UPDATE Mechanics SET car_assigned = ? WHERE mechanic_id = ?";
	String url = "jdbc:mysql://localhost:3306/fastcare";
	String username = "root";
	String password = "Venkas0610";
	public void update(int carNumber, int mechanicId) {
		try {
		    Connection connection = DriverManager.getConnection(url, username, password);
		    // Use the connection object for further database operations
		    PreparedStatement statement = connection.prepareStatement(assignMechanicSql);
		    statement.setInt(1, carNumber);
		    statement.setInt(2, mechanicId);

		    statement.executeUpdate();
		    
		    statement.close();
		    System.out.println("Update dao works");
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
}
