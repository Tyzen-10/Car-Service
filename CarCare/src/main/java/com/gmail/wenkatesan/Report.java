package com.gmail.wenkatesan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//getting session variable
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		//session.setAttribute("username", uname);
		
//		String sql = "SELECT u.uname, mc.car_assigned, mc.mechanic_id from users as u join Mechanics as mc on u.uname = mc.mech_username where u.uname = ?";
		String sql1 = "SELECT c.uname,mc.car_assigned, mc.mechanic_id from cars as c join Mechanics as mc on c.car_number = mc.car_assigned where mc.mech_username = ? ";
//		String sql2 = "SELECT mechanic_id FROM Mechanics where car_assigned is null";
		String url = "jdbc:mysql://localhost:3306/fastcare";
		String user = "root";
		String password = "Venkas0610";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement st = conn.prepareStatement(sql1);
			st.setString(1,username);
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("c.uname");
			int assigned = rs.getInt("mc.car_assigned");
			int mid = rs.getInt("mc.mechanic_id");
			//setting session variables
			session.setAttribute("caruser", uname);
			session.setAttribute("asscar", assigned);
			session.setAttribute("mechid", mid);
			//request.setAttribute("mechname", uname);
			//request.setAttribute("asscar", assigned);
			//request.setAttribute("mechid", mid);
			request.getRequestDispatcher("Report.jsp").forward(request, response);
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
