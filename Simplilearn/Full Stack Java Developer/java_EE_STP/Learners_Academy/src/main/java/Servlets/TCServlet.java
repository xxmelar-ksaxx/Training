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
import DAL.Subject_DAL;
import DAL.TC_DAL;
import DAL.Teachers_DAL;
import Entities.Classes;
import Entities.Subjects;
import Entities.Teachers;
import Entities.Teachers_Classes;

/**
 * Servlet implementation class TCServlet
 */
public class TCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	   Classes_DAL cDal;
	   Teachers_DAL tDal;
	   TC_DAL tcDal;
	    
	    public void init() {
	 	   cDal = new Classes_DAL();
	 	   tDal = new Teachers_DAL();
	 	   tcDal = new TC_DAL();
	    }

		
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	   
	 	   doGet(request, response);
	    }
		
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String action = request.getServletPath();
		        try {
		        	 switch (action) {
		        	 
		        	 	case "/inserst_TC": 
		                    insertUser(request, response);
		                    break;
		        	 	case "/list_TC": 
		        	 		//listUser(request, response);
		        	 		getTCnames(request, response);
		                    break;
		        	 	case "/delete_tc": 
		        	 		deleteSubject(request, response);
		                    break;
		        	 	
		        	 	
		                 	             
		        	 }
		          
		        } catch (SQLException ex) {
		            throw new ServletException(ex);
		        }
		}

	    private void insertUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    	  		
	    			String t_name_id = request.getParameter("t_name");
	    	        String class1_id = request.getParameter("c_name");
	    	       
	    	       if(t_name_id==null || class1_id==null) {
	    	    	   request.setAttribute("TheState", false);
	    	    	   
	    	    	   //response.sendRedirect("list_TC");
	    	       }
	    	       else {
	    	    	
	    	        Object teacher=tcDal.getTC_E_info(Integer.parseInt(t_name_id),"T");
	    	        Object class1=tcDal.getTC_E_info(Integer.parseInt(class1_id),"C");
	    	       
	    	        Teachers_Classes teachers = new Teachers_Classes((Teachers)teacher, (Classes)class1);
	    	        
	    	        tcDal.saveUser(teachers);  // 2nd argument for the DML type (CRUD)
	    	        
	    	       }
	    	        try {
						//listUser(request, response);
	    	        	getTCnames(request, response);
					} catch (Exception e) {
						System.out.println("list teachers (try block) error!!");
					}
	    	        
	    	    }
	    
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        List<Object[]> list_tc = tcDal.getAllUser();
	    	        
	    	        request.setAttribute("list_tc", list_tc);
	    	        
	    	        
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("TC.jsp");
	    	        dispatcher.forward(request, response);
	    	        
	    	        //response.sendRedirect("Classes.jsp");
	    	    }
		
	    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    			
	    			int id = Integer.parseInt(request.getParameter("id"));
	    			tcDal.deleteUser(id);
	    			
	    			 try {
	    				 getTCnames(request, response);
	 				} catch (Exception e) {
	 					System.out.println("list teachers error!!");
	 				}
	    	    }
	    
	    private void getTCnames(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    			
	    			List < Teachers > listTnames = tDal.getAllUser();
	    	        request.setAttribute("listteachers", listTnames);
	    	        List < Classes > listCnames = cDal.getAllUser();
	    	        request.setAttribute("listclasses", listCnames);
	    			
	    			 try {
	 					listUser(request, response);
	 				} catch (Exception e) {
	 					System.out.println("list teachers error!!");
	 				}
	    	    }

}
