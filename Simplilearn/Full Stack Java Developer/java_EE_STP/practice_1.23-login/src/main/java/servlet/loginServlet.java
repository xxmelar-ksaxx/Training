package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
					doGet(request, response);
				
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String action = request.getServletPath();
			
			if(action == "/logout") {
				response.sendRedirect("index.jsp");
			}
			else {
				
			System.out.println("Inside the Login Servlet");
			
			String name = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        boolean state=false;
	       
	        String username="yousif";
	        String userpassword="1234";
	        
	        	if(name.equals(username) && password.equals(userpassword)) {
	        		
	        		request.setAttribute("name", name);
	        		
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("valid.jsp");
	        		dispatcher.forward(request, response);	        	
	        	}
	        	else {
	        		request.setAttribute("TheState", state);
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        		dispatcher.forward(request, response);

	        	}
			}
	        
			
	}

}
