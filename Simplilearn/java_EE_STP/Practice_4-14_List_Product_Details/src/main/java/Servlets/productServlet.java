package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class productServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private static String name;
    private static String price;
    private static String pid;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        doGet(request, response);
    	    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        try {
	                    insertUser(request, response);
	                    
	                    
    	        
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
    	    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    			 
    			name = request.getParameter("product_name");
    	         price = request.getParameter("product_price");
    	         pid = request.getParameter("product_id");
    	         
    	        
    	        System.out.println("name and price are: "+name+"-"+price);
    	        
    	        // Check if price isn't integer
    	       
    	        if(name.equals("") || price.equals("") || pid.equals("")) {
    	        	request.setAttribute("TheState","");
    	        	request.setAttribute("TheState_2","missing");
    	        }
    	        else {
    	        	
    	        	try {
        	        	Integer.parseInt(price);
        	        	System.out.println("no Errors yet");
        	        	request.setAttribute("TheState","not null");
        	        	request.setAttribute("TheState_2","not null");
        	        	request.setAttribute("name", name);
        	        	request.setAttribute("price", price);
        	        	request.setAttribute("id", pid);
        	        	
        	        }catch (NumberFormatException e) {
        	        	
    					System.out.println("Not int !!!");
    					
    					request.setAttribute("TheState_2","number");
        	        	
    				}
    	        	
    	        }
    	    
    	        try {
					listUser(request, response);
				} catch (Exception e) {
					System.out.println("list Products error!!");
				}
    	        
    	    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	System.out.println("Dispather on");
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("product_info.jsp");
    	        dispatcher.forward(request, response);
    	    }
    
}
