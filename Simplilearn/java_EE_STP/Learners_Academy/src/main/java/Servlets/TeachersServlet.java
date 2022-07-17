package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.Teachers_DAL;
import Entities.Subjects;
import Entities.Teachers;


public class TeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Teachers_DAL tDal;
    
       public void init() {
    	   tDal = new Teachers_DAL();
       }

	
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   
    	   doGet(request, response);
       }
	
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        try {
	        	 switch (action) {
	        	 
	        	 	case "/insert_teacher": 
	                    insertUser(request, response);
	                    break;
	        	 	case "/list_teacher": 
	        	 		listUser(request, response);
	                    break;
	        	 	case "/delete_teacher": 
	        	 		deleteSubject(request, response);
	                    break;
	        	 	
	        	 	
	                 	             
	        	 }
	          
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	}

       private void insertUser(HttpServletRequest request, HttpServletResponse response)
       	    throws SQLException, IOException {
       	  		System.out.println("3");
       			String name = request.getParameter("name");
       	        String email = request.getParameter("email");
       	        String gender = request.getParameter("gender");
    	        String age = request.getParameter("age");
    	        String role = request.getParameter("role");
       	      	
    	        if(  name.equals("") ||   age.equals("") ) {
    	        	request.setAttribute("TheState", false);
    	        }
    	        else {
    	        	
    	        Teachers teacher = new Teachers(name,email,gender,Integer.parseInt(age),role);
       	        
       	        tDal.saveUser(teacher);  // 2nd argument for the DML type (CRUD)
       	        
    	        }
       	        try {
   					listUser(request, response);
   				} catch (Exception e) {
   					System.out.println("list teachers (try block) error!!");
   				}
       	        
       	    }
       
       private void listUser(HttpServletRequest request, HttpServletResponse response)
       	    throws SQLException, IOException, ServletException {
       	        List < Teachers > listUser = tDal.getAllUser();
       	        request.setAttribute("listUser", listUser);
       	        
       	        
       	        RequestDispatcher dispatcher = request.getRequestDispatcher("Teachers.jsp");
       	        dispatcher.forward(request, response);
       	    }
	
       private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
       	    throws SQLException, IOException, ServletException {
       			System.out.println("in delete ");
       			int id = Integer.parseInt(request.getParameter("id"));
       			tDal.deleteUser(id);
       			
       			 try {
    					listUser(request, response);
    				} catch (Exception e) {
    					System.out.println("list teachers error!!");
    				}
       	    }
       
}
