package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.Classes_DAL;
import DAL.Student_DAL;
import DAL.Teachers_DAL;
import Entities.Classes;
import Entities.Students;
import Entities.Subjects;
import Entities.Teachers;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Student_DAL sDal;
    Classes_DAL cDal;
    
    public void init() {
 	   sDal = new Student_DAL();
 	   cDal = new Classes_DAL();
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	   
 	   doGet(request, response);
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        try {
	        	 switch (action) {
	        	 
	        	 	case "/insert_student": 
	                    insertUser(request, response);
	                    break;
	        	 	case "/list_student": 
	        	 		//listUser(request, response);
	        	 		getclassesnames(request, response);
	                    break;
	        	 	case "/delete_student": 
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
    	        String gender = request.getParameter("jender");
	 	        String age = request.getParameter("age");
	 	        String role = request.getParameter("role");
	 	        String class1 = request.getParameter("class1");
    	      
	 	       if(  name.equals("") ||   age.equals("") ) {
	 	    	   request.setAttribute("TheState", false);
	 	       }
	 	       else {
	 	        
    	        Students student = new Students(name,email,gender,Integer.parseInt(age),role,Integer.parseInt(class1));
    	        
    	        sDal.saveUser(student);  // 2nd argument for the DML type (CRUD)
	 	       }
    	        
    	        try {
    	        	getclassesnames(request, response);
				} catch (Exception e) {
					System.out.println("list teachers (try block) error!!");
				}
    	        
    	    }
    
    private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List<Object[]> listUser = sDal.getAllUser();
    	        request.setAttribute("listUser", listUser);
    	    
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Students.jsp");
    	        dispatcher.forward(request, response);
    	    }
	
    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    			System.out.println("in delete ");
    			int id = Integer.parseInt(request.getParameter("id"));
    			sDal.deleteUser(id);
    			
    			 try {
    				 getclassesnames(request, response);
 				} catch (Exception e) {
 					System.out.println("list teachers error!!");
 				}
    	    }
    
    private void getclassesnames(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    			
    			List<Classes> listclasses = cDal.getAllUser();
    	        request.setAttribute("listclasses", listclasses);
    			
    			 try {
 					listUser(request, response);
 				} catch (Exception e) {
 					System.out.println("list teachers error!!");
 				}
    	    }
    
}


