package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import DAL.Subject_DAL;
import Entities.Subjects;


public class createSubjectListner extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private Subject_DAL sDal;   
    
    
    public void init() {
		sDal = new Subject_DAL();
    	
	}
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    			System.out.println("1");
    	        doGet(request, response);
    	    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	 		System.out.println("2"); 
    	        String action = request.getServletPath();
    	        
    	        System.out.println(action);
    	        
    	        try {
    	        	 switch (action) {
    	        	 
    	        	 	case "/insert": 
    	                    insertUser(request, response);
    	                    break;
    	        	 	case "/list": 
    	        	 		listUser(request, response);
    	                    break;
    	        	 	case "/delete": 
    	        	 		deleteSubject(request, response);
    	                    break;
    	        	 	case "/test_1": 
    	        	 		test_1(request, response);
    	                    break;
    	                 	             
    	        	 }
    	          
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
    	    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	  		System.out.println("3");
    			String name = request.getParameter("subject_input");
    	        String email = request.getParameter("credits_input");
    	       
    	        if(name.equals("") || email.equals("")) {
    	        	request.setAttribute("TheState", false);
    	        }
    	        else {
    	        
    	        Subjects newUser = new Subjects(name,Integer.parseInt(email));
    	        System.out.println("4");
    	        sDal.saveUser(newUser,"update");  // 2nd argument for the DML type (CRUD)
    	        }
    	        
    	        try {
					listUser(request, response);
				} catch (Exception e) {
					System.out.println("list subjects error!!");
				}
    	        
    	    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List < Subjects > listUser = sDal.getAllUser();
    	        request.setAttribute("listUser", listUser);
    	    
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Subjects.jsp");
    	        dispatcher.forward(request, response);
    	    }
    
    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    			System.out.println("in delete ");
    			int id = Integer.parseInt(request.getParameter("id"));
    			sDal.deleteUser(id, "none");
    			
    			 try {
 					listUser(request, response);
 				} catch (Exception e) {
 					System.out.println("list subjects error!!");
 				}
    	    }
    private void test_1(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    			System.out.println("in s test 1 ");
    			
    			
    			 try {
 					listUser(request, response);
 				} catch (Exception e) {
 					System.out.println("list subjects error!!");
 				}
    	    }    
    
    
}
