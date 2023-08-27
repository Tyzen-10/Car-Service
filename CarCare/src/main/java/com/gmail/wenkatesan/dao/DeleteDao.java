package com.gmail.wenkatesan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDao {
	String sql = "DELETE FROM cars WHERE car_number = ?";
//	String assignMechanicSql = "UPDATE Mechanics SET car_assigned = ? WHERE mechanic_id = ?";
	String url = "jdbc:mysql://localhost:3306/fastcare";
	String username = "root";
	String password = "Venkas0610";
	public void delete(int carNumber) {
		try {
		    Connection connection = DriverManager.getConnection(url, username, password);
		    // Use the connection object for further database operations
		    PreparedStatement statement = connection.prepareStatement(sql);
		    statement.setInt(1, carNumber);

		    statement.executeUpdate();
		    
		    statement.close();
		    System.out.println("Delete dao works");
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
}
