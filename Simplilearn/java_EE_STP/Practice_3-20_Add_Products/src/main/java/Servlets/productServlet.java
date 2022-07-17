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
import Products_DAL.Product_DAL;
import Entities.Products;


public class productServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private Product_DAL pDal;   
    private static String name;
    private static String price;
  
    public void init() {
		pDal = new Product_DAL();
    	
	}
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    			       
    			doGet(request, response);
    	    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String action = request.getServletPath();
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
    	                 	             
    	        	 }
    	          
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
    	    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    			 name = request.getParameter("product_name");
    	         price = request.getParameter("product_price");
    	        
    	        System.out.println("name and price are: "+name+"-"+price);
    	        
    	        if(name.equals("") || price.equals("")) {
    	        	request.setAttribute("TheState","");
    	        	request.setAttribute("TheState_2","missing");
    	        }
    	        else {
    	        	request.setAttribute("TheState","not null");
    	        	request.setAttribute("TheState_2","not null");
    	        	request.setAttribute("name", name);
    	        	request.setAttribute("price", price);
    	        
    	        try {    	        	
	        	
    	        	
    	        	
    	        Products newUser = new Products(name,Integer.parseInt(price));        
    	       
    	        pDal.saveUser(newUser,"update");  // 2nd argument for the DML type (CRUD)
    	        
    	        
    	        
    	        
    	        
    	        }catch (Exception e) {
    	        	request.setAttribute("TheState_2","number");
				}
    	        
    	        }
    	        
    	        try {
					listUser(request, response);
				} catch (Exception e) {
					System.out.println("list subjects error!!");
				}
    	        
    	    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List < Products > listProduct = pDal.getAllProducts();
    	        request.setAttribute("listProduct", listProduct);
    	        
    	     
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("product_info.jsp");
    	        dispatcher.forward(request, response);
    	    }
    
    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    			System.out.println("in delete ");
    			int id = Integer.parseInt(request.getParameter("id"));
    			pDal.deleteProduct(id, "none");
    			
    			 try {
 					listUser(request, response);
 				} catch (Exception e) {
 					System.out.println("list subjects error!!");
 				}
    	    }
    
}
