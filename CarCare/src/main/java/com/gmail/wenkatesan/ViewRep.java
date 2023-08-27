package com.gmail.wenkatesan;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewRep
 */
@WebServlet("/ViewRep")
public class ViewRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRep() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
//		String sql = "UPDATE Mechanics SET car_assigned = ? WHERE mechanic_id = ?";
		System.out.println("ViewRep.java works");
		String url = "jdbc:mysql://localhost:3306/fastcare";
		String username = "root";
		String password = "Venkas0610";
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		
        // Set the response content type to HTML
   //     response.setContentType("text/html");
    //    PrintWriter out = response.getWriter();
        
        
        
        try {
        	Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM reports WHERE owner_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the retrieved records
            List<View> viewList = new ArrayList<>();
            while (resultSet.next()) {
                int report_id = resultSet.getInt("report_id");
                String reportContent = resultSet.getString("report_content");
                String reportOwner = resultSet.getString("owner_name");
                View view = new View(report_id, reportContent, reportOwner);
                viewList.add(view);
            }

            // Set the list as a request attribute
            request.setAttribute("viewList", viewList);

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
            request.setAttribute("errorMessage", "An error occurred while processing the request.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewRep.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



