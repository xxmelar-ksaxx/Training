package Servlets;

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
import DAL.Subject_DAL;
import Entities.Classes;
import Entities.Students;
import Entities.Subjects;

public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   Classes_DAL cDal;
	   Subject_DAL sDal;
	    
	    public void init() {
	 	   cDal = new Classes_DAL();
	 	   sDal = new Subject_DAL();
	    }

		
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	   
	 	   doGet(request, response);
	    }
		
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String action = request.getServletPath();
		        try {
		        	 switch (action) {
		        	 
		        	 	case "/insert_class": 
		                    insertUser(request, response);
		                    break;
		        	 	case "/list_classes": 
		        	 		//listUser(request, response);
		        	 		getSubjectsnames(request, response);
		                    break;
		        	 	case "/delete_class": 
		        	 		deleteSubject(request, response);
		                    break;
		        	 	case "/get_subject_names": 
		        	 		getSubjectsnames(request, response);
		                    break;
		        	 	case "/class_info": 
		        	 		getClassInfo(request, response);
		                    break;
		        	 	case "/class_info_refrech":
		        	 		getClassInfo_refresh(request, response);
		                    break;
		        	 	
		                 	             
		        	 }
		          
		        } catch (SQLException ex) {
		            throw new ServletException(ex);
		        }
		}

	    private void insertUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	  		
	    			String name = request.getParameter("subject_name");
	    	        String room = request.getParameter("room_no");
	    	        String time = request.getParameter("class_time");
	    	        
	    	        
	    	        
	    	        if( name==null || room==null || time==null) {
	    	        	request.setAttribute("TheState", false);
	    	        }
	    	        else {
	    	        	
	    	        Subjects subject=sDal.getSubject(name);
	    	        
	    	        Classes classes = new Classes(subject,Integer.parseInt(room),Integer.parseInt(time));
	    	        
	    	        cDal.saveUser(classes);  // 2nd argument for the DML type (CRUD)
	    	        }
	    	        
	    	        try {
						//listUser(request, response);
	    	        	getSubjectsnames(request, response);
					} catch (Exception e) {
						System.out.println("list teachers (try block) error!!");
					}
	    	        
	    	    }
	    
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        List<Object[]> listClasses = cDal.getAllUser();
	    	        
	    	        request.setAttribute("listClasses", listClasses);
	    	    
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Classes.jsp");
	    	        dispatcher.forward(request, response);
	    	        
	    	        //response.sendRedirect("Classes.jsp");
	    	    }
		
	    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    			
	    			int id = Integer.parseInt(request.getParameter("id"));
	    			cDal.deleteUser(id);
	    			
	    			 try {
	    				 getSubjectsnames(request, response);
	 				} catch (Exception e) {
	 					System.out.println("list teachers error!!");
	 				}
	    	    }
	    
	    private void getSubjectsnames(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    			
	    			List < Subjects > listSubjects = sDal.getAllUser();
	    	        request.setAttribute("listSubjects", listSubjects);
	    			
	    			 try {
	 					listUser(request, response);
	 				} catch (Exception e) {
	 					System.out.println("list teachers error!!");
	 				}
	    	    }
	    private void getClassInfo(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    			
			    	List<Object[]> listClasses = cDal.getAllUser();
			    	request.setAttribute("lci", listClasses);
	    			
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Class_info.jsp");
	    	        dispatcher.forward(request, response);
	    	    }
	    
	    private void getClassInfo_refresh(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    			
	    			
			    	String name = request.getParameter("class_inf_id");
			    	
			    	System.out.println(" $$$ prameter value= -"+name+"-");
	    			List class_info = cDal.get_Class_Info(name);
	    	        request.setAttribute("class_info", class_info);
	    	        
	    	        try {
	 					getClassInfo(request, response);
	 				} catch (Exception e) {
	 					System.out.println("list teachers error!!");
	 				}
	    	        
	    	    }
	    

}
