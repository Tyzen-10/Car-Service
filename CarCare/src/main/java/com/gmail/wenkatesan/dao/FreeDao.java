package com.gmail.wenkatesan.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FreeDao {
	String sql  = "UPDATE Mechanics SET car_assigned = NULL WHERE mechanic_id = ?";
	String url = "jdbc:mysql://localhost:3306/fastcare";
	String username = "root";
	String password = "Venkas0610";
	public void free(int carNumber, int mechanicId) {
		try {
		    Connection connection = DriverManager.getConnection(url, username, password);
		    // Use the connection object for further database operations
		    PreparedStatement statement = connection.prepareStatement(sql);
		    statement.setInt(1, mechanicId);
			/* statement.setInt(2, mechanicId); */

		    statement.executeUpdate();
		    
		    statement.close();
		    System.out.println("Free dao works");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
