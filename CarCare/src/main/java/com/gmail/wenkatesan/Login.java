package com.gmail.wenkatesan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.wenkatesan.dao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginDao dao = new LoginDao();
		if(dao.check(uname, pass)&&uname.equals("admin")){
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			System.out.println("in if condition");
			response.sendRedirect("AdminHome.jsp");
			
		}
		else if(dao.check(uname,pass)&&uname.contains(String.valueOf('@'))){
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			System.out.println("in mechanic condition"+ uname);
			response.sendRedirect("MechHome.jsp");
		}
		else if(dao.check(uname,pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			System.out.println("in else condition"+ uname);
			response.sendRedirect("UserHome.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}


/*comment line   String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginDao dao = new LoginDao();
		if(dao.check(uname,pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("UserHome.jsp");*/