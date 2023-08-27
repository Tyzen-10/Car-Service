package com.gmail.wenkatesan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.wenkatesan.dao.ComplaintDao;

/**
 * Servlet implementation class Complaint
 */
@WebServlet("/Complaint")
public class Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Complaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* doGet(request, response); */
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int car_number = Integer.parseInt(request.getParameter("car_number"));
		String car_make = (String) request.getParameter("car_make");
		String car_model = (String) request.getParameter("car_model");
		int car_year = Integer.parseInt(request.getParameter("car_year"));
		ComplaintDao complaint = new ComplaintDao();
		complaint.submit(car_number, car_make, car_model, car_year, username);
		response.sendRedirect("UserHome.jsp");
	}

}
