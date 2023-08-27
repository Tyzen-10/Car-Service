package com.gmail.wenkatesan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CheckMechanic {
	String sql = "SELECT * FROM Mechanics WHERE car_assigned IS NULL";
	String url = "jdbc:mysql://localhost:3306/fastcare";
	String username = "root";
	String password = "Venkas0610";
	public int isMechanicFree() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			//	int rowCount = rs.getInt("row_count");
				System.out.println("Mechanic Free method works");
				return 1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
