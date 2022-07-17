package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;



public class SummaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    
    public SummaryServlet() {
        super();
    
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session= request.getSession(false);
		
		if(session !=null) {
		   	User u=(User) session.getAttribute("user");
			
			u.setCity(request.getParameter("city"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			session.setAttribute("user",u);
			
			PrintWriter out = response.getWriter();
			
			out.println("<h2> Hello"+ u.getEmail()+"  </h2>");
			out.println("<h3> Details .."+ u +"  </h3>");
			out.println("<h4> Sesston ID = "+ session.getId()+"  </h4>");
			out.println("<h4> Sesston Created at = "+ session.getCreationTime()+"  </h4>");
			
			session.invalidate();
			
			
			
		}
		
	}

}
