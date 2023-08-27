package com.gmail.wenkatesan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.gmail.wenkatesan.dao.DeleteDao;
import com.gmail.wenkatesan.dao.OneDao;
import com.gmail.wenkatesan.dao.UpdateDao;

/**
 * Servlet implementation class SetJob
 */
@WebServlet("/SetJob")
public class SetJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int param1 = Integer.parseInt(request.getParameter("carNumberDropdown"));
		int param2 = Integer.parseInt(request.getParameter("mechanicIdDropdown"));
		System.out.println(param1 + "Params in setjobservlet" + param2);
		UpdateDao up = new UpdateDao();
		up.update(param1, param2);
		OneDao one = new OneDao();
		one.one(param1);
		
//		DeleteDao del = new DeleteDao();
//		del.delete(param1);
		response.sendRedirect("Assign");

		
		
		
	}

}
