package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAL.login_DAL;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private login_DAL loginDLA;   
	    
	    
	    public void init() {
	    	loginDLA = new login_DAL();
	    	
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		       doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("Inside the Login Servlet");
			
			String name = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        boolean state=loginDLA.loginValidation(name, password);
	        System.out.println("the login state is: "+state);
	        
	        	if(state==true) {
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
	        		dispatcher.forward(request, response);	        	
	        	}
	        	else {
	        		request.setAttribute("TheState", state);
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        		dispatcher.forward(request, response);	
	        	}
	        
			
	}

}
