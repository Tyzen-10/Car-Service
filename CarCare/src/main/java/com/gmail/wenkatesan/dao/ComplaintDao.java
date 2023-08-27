package com.gmail.wenkatesan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ComplaintDao {
	String sql2  = "INSERT INTO cars (car_number, car_make, car_model, car_year, uname) VALUES (?, ?, ?, ?, ?)";
	String url = "jdbc:mysql://localhost:3306/fastcare";
	String username = "root";
	String password = "Venkas0610";
	
	public void submit(int car_number,String car_make,String car_model, int car_year, String uname) {
		try {
		    Connection connection = DriverManager.getConnection(url, username, password);
		    // Use the connection object for further database operations
		    PreparedStatement statement = connection.prepareStatement(sql2);
			/*
			 * statement.setInt(1, carNumber); statement.setInt(2, mechanicId);
			 */
		    statement.setInt(1, car_number);
		    statement.setString(2, car_make);
		    statement.setString(3, car_model);
		    statement.setInt(4, car_year);
		    statement.setString(5, uname);

		    statement.executeUpdate();
		    
		    statement.close();
		    System.out.println("Complaint sumbit dao works");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
