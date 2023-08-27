package com.gmail.wenkatesan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.wenkatesan.dao.DeleteDao;
import com.gmail.wenkatesan.dao.FreeDao;
import com.gmail.wenkatesan.dao.RepSubDao;


/**
 * Servlet implementation class Free
 */
@WebServlet("/Free")
public class Free extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Free() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* doGet(request, response); */
		//session variables
		HttpSession session = request.getSession();
		//String username = (String) session.getAttribute("username");
		String caruserValue = (String) session.getAttribute("caruser");
		int asscarValue = (int) session.getAttribute("asscar");
		int mechidValue = (int) session.getAttribute("mechid");
		
/*		int asscarValue = (int) request.getAttribute("asscar");
		int mechidValue = (int) request.getAttribute("mechid");*/
		String param1 = request.getParameter("content");
		RepSubDao sub = new RepSubDao();
		sub.submit(mechidValue,asscarValue,param1,caruserValue);
		System.out.println("report submitted");
		DeleteDao del = new DeleteDao();
		del.delete(asscarValue);
		FreeDao freed = new FreeDao();
		freed.free(asscarValue,mechidValue);
		System.out.println("Mechanic" + mechidValue + "is free");
		
	}

}
