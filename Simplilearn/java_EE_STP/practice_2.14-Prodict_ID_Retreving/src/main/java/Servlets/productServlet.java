package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.Product_DAL;

/**
 * Servlet implementation class productServlet
 */
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Product_DAL pDal;
	
	public void init() {
		pDal= new Product_DAL();
	}
   
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	   
	 	   doGet(request, response);
	    }
		
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       
		          try {
					getProduct(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.println("get Product: call error!");
					e.printStackTrace();
				}
		        
		}
	    
	    private void getProduct(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        
	    			String pid="";	
	    			pid = request.getParameter("product_id");
	    	
	    			List<Object[]> listProduct = pDal.getProduct(pid);
	    			System.err.println("Type is: "+listProduct.getClass());
	    			for(Object[] k:listProduct) {
						System.out.println(k[0]);
						System.out.println(k[1]);
					}
	    	        request.setAttribute("listProduct", listProduct);
	    	        
	    	        if(listProduct.isEmpty()) {						// To indcate no recourd is found
	    	        	request.setAttribute("start", "none");
	    	        }
	    	    
	    	        request.setAttribute("id_no", pid);
	    	        
	    	        
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("product_info.jsp");
	    	        dispatcher.forward(request, response);
	    	        
	    	        //response.sendRedirect("Classes.jsp");
	    	    }
	    

}
