package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;



public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SecondServlet() {
        super();
    
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		HttpSession session= request.getSession(false);
		
		if(session !=null) {
		   	User u=(User) session.getAttribute("user");
			
			u.setEmail(request.getParameter("email"));
			u.setAge(Integer.parseInt(request.getParameter("age")));
			session.setAttribute("user",u);
			response.sendRedirect("three.html");
			
		}
		
		
		
		
	}

}
