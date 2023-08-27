package com.gmail.wenkatesan;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assign
 */
@WebServlet("/Assign")
public class Assign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String sql = "SELECT car_number FROM cars where assigned is null";
		String sql2 = "SELECT mechanic_id FROM Mechanics where car_assigned is null";
		String url = "jdbc:mysql://localhost:3306/fastcare";
		String username = "root";
		String password = "Venkas0610";
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			List<Integer> carNumbers = new ArrayList<>();
		//	String carQuery = "SELECT car_number FROM car";
			Statement carStatement = conn.createStatement();
			ResultSet carResultSet = carStatement.executeQuery(sql);
			while (carResultSet.next()) {
			    int carNumber = carResultSet.getInt("car_number");
			    carNumbers.add(carNumber);
			}
			System.out.println("List 1 done");

			// Retrieve mechanic IDs from the mechanic table
			List<Integer> mechanicIds = new ArrayList<>();
		//	String mechanicQuery = "SELECT mechanic_id FROM mechanic";
			Statement mechanicStatement = conn.createStatement();
			ResultSet mechanicResultSet = mechanicStatement.executeQuery(sql2);
			while (mechanicResultSet.next()) {
			    int mechanicId = mechanicResultSet.getInt("mechanic_id");
			    mechanicIds.add(mechanicId);
			}
			System.out.println("List 2 done");
			// Close the resources
			carResultSet.close();
			carStatement.close();
			mechanicResultSet.close();
			mechanicStatement.close();
			conn.close();
			request.setAttribute("carNumbers", carNumbers);
			request.setAttribute("mechanicIds", mechanicIds);
			request.getRequestDispatcher("Assign.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
