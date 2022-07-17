package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;


public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	public LoginController() {
        super();

    }

    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username= request.getParameter("Username");
		String password= request.getParameter("Password");
		
		RequestDispatcher rd = null;
		if(username.equalsIgnoreCase("tom") && password.equals("jerry")) {
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("login.html");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center> <spann style='color:red'>Invalid Credentials!!</span> </center>");
			
		}
		
	}

}
