package com.gmail.wenkatesan.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//import com.mysql.cj.xdevapi.Statement;


public class RepSubDao {
	String sql1 = "SELECT MAX(report_id) FROM reports";
	String sql2  = "INSERT INTO reports (report_id, mechanic_id, car_assigned, report_content, owner_name) VALUES (?, ?, (SELECT car_assigned FROM mechanics WHERE mechanic_id = ?), ?,?)";
	String url = "jdbc:mysql://localhost:3306/fastcare";
	String username = "root";
	String password = "Venkas0610";
	
	public void submit(int mechanic_id, int car_assigned, String content, String own) {
		//find next report id
        // initializing maxReportId
		int maxReportId = 0;
		//initializing nextReportId
		int nextReportId = 0;
		try {
		    Connection connection = DriverManager.getConnection(url, username, password);
		    // Use the connection object for further database operations
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);

            // Execute the prepared statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result
            if (resultSet.next()) {
                maxReportId = resultSet.getInt(1);
                System.out.println("Max Report ID: " + maxReportId);
            }
            nextReportId = maxReportId + 1;

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
		    System.out.println("Retrived max of reports");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		//for submitting report
		try {
		    Connection connection = DriverManager.getConnection(url, username, password);
		    // Use the connection object for further database operations
		    PreparedStatement statement = connection.prepareStatement(sql2);
			/*
			 * statement.setInt(1, carNumber); statement.setInt(2, mechanicId);
			 */
		    statement.setInt(1, nextReportId);
		    statement.setInt(2, mechanic_id);
		    statement.setInt(3, mechanic_id);
		    statement.setString(4, content);
		    statement.setString(5, own);

		    statement.executeUpdate();
		    
		    statement.close();
		    System.out.println("Repsubdao try2");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}

